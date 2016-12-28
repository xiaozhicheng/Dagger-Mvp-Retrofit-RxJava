# Dagger2入门使用

关于 Dagger2 自己一只想搞明白，但是从去年开始到现在，说真的，看过不少介绍 Dagger2 的文章，但自己一只云里雾里，最近打算把 Dagger2 应用到 MVP 框架中去，所以就重新翻看相关技术文章，重新学习下，下面算是自己这两天学习 Dagger2 后对 Dagger2 的认识，不一定都正确，如果 错误，欢迎指正，只要从代码角度出发，认识 Dagger2。

Note:如果你对 MVP 和 Retrofit 都不熟悉，这篇文章可能不适合你阅读。

首先，对于一般来说，想创建一个对象，我们肯定采取new的形式:

	MainPresenter mainPresenter = new MainPresenter(context,user);
但是这样耦合度较高，presenter的变化受限于Activity，也就是说假如我们的presenter的参数变成三个了，又要改Activity代码。所以使用Dagger2的好处就很明显了，如果改了构造器，只需要改对应的Module就可以。

##环境配置

根目录的 build 文件加入 android-apt 支持

	buildscript {
	    repositories {
	        jcenter()
	    }
	    dependencies {
	        classpath 'com.android.tools.build:gradle:1.1.0'
	        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.4'
	        // NOTE: Do not place your application dependencies here; they belong
	        // in the individual module build.gradle files
	    }
    }

在 app 目录的 build 文件中加入 apt plugin 的支持

	apply plugin: 'com.neenbedankt.android-apt'
加入 Dagger2 retrofit OkHttp 依赖

	//dagger2
	compile 'com.google.dagger:dagger:2.0'
	apt 'com.google.dagger:dagger-compiler:2.0'
	provided 'org.glassfish:javax.annotation:10.0-b28'
	
	//Square
	compile 'com.jakewharton:butterknife:6.1.0'
	compile 'com.squareup.retrofit:retrofit:1.9.0'

##在 Application 中实践 Dagger2

	public class AppAplication extends Application {
	
	    private AppComponent appComponent;
	
	    @Override
	    public void onCreate() {
	        super.onCreate();
	        appComponent = DaggerAppComponent.builder()
	                .appModule(new AppModule(this))
	                .appServiceModule(new AppServiceModule())
	                .apiServiceModule(new ApiServiceModule())
	                .build();
	
	    }
	}

###@Module

上面提到了Module，这是什么呢？其实这是一个提供参数的地方，将new Presenter所需要的参数，写到这里面来了。看示例代码：

	@Module //注解说明这是Module
	public class AppModule {

    	private Application application;

	    public AppModule(Application application){
	        this.application = application;
	    }

	    @Singleton
	    @Provides
	    public Application provideApplication(){
	        return application;
	    }
	}
这是Module的写法，就是把new Presenter(Context,View)写到了里面。

###@Inject
Module怎么知道presenter构造器需要几个参数呢，答案是@Inject ，只需要在Presenter的构造器注解

	public class MainPresenter {

	    private MainActivity mainActivity;
	
	    private User user;

	    @Inject
	    public MainPresenter(MainActivity activity,User user){
	        this.mainActivity = activity;
	        this.user = user;
	    }
	}

###@Component

连接Presenter和Module的东东，我们只需要写一个接口，来返回Presenter对象，Dagger2就会自动生成对应的对象给我们。

	//注解标注Component 并且告知需要的module是什么
	@Singleton
	@Component(modules = {AppModule.class, ApiServiceModule.class, AppServiceModule.class})
	public interface AppComponent {
	
	    Application getApplicaiton();
	
	    ApiService getService();
	
	    User getUser();
	}
