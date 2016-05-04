# GoogleAnalyticsSample
最少的代码完成最基本的功能

    0. 申请一个Google Analytics 账号
    1. 创建一个android工程
    2. 从sdk目录copy google play service 的google-play-services.jar和version.xml
    3. manifest添加google_play_services_version和INTERNET/ACCESS_NETWORK_STATE权限
    4. Tracker t =  GoogleAnalytics.getInstance(this).newTracker("对应的trackId");
        t.setScreenName("随便来个name就可以");
        t.send(new HitBuilders.AppViewBuilder().build());
