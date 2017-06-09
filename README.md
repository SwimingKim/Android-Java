# Android  
  
0. JDK   
  오라클 홈페이지에서 OS에 맞는 JDK
   
1. 이클립스  
  이클립스 설치 : SE 혹은 EE  
  SDK 설치 : http://www.android.pk/android-sdk.php  
  ADT 설치 : https://dl-ssl.google.com/android/eclipse/  
   
2. 스튜디오  
   스튜디오 설치 : https://developer.android.com/studio/index.html  
   
# Unity Plugins

(1) 안드로이드 스튜디오
1. 안드로이드 스튜디오에서 라이브러리 프로젝트를 만든다.
```
apply plugin : 'com.android.library'

android {
    compileSdkVersion 25
    buildToolsVersion "25.0.3"
    defaultConfig {
        minSdkVersion 16
        targetSdkVersion 25
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.3.1'
    testCompile 'junit:junit:4.12'
    compile files('libs/classes.jar')
}

// task to delete the old jar
task deleteOldJar(type: Delete) {
    delete 'release/AndroidPlugine.jar'
}

// taks to export contents as jar
task exportJar(type: Copy) {
    from('build/intermediates/bundles/default/')
    into('release/')
    include('classes.jar')
    // Rename the jar
    rename('classes.jar', 'AndroidPlugin.jar')
}

exportJar.dependsOn(deleteOldJar, build)
```

2. 자바 클래스를 만든다
```
public Activity mUnityActivity = null;
public String  strMessage = null;

public void setUnityActivity(Activity obj) {
    mUnityActivity = obj;
}

public void showToast(final String strMessage) {
    this.strMessage = strMessage;

    mUnityActivity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(mUnityActivity, strMessage, Toast.LENGTH_LONG).show();
            Log.d("Unity", "Toast 출력");
        }
    });
}
```
```
// UnityPlayer.UnitySendMessage("프리팹이름", "함수이름", "매개변수");
UnityPlayer.UnitySendMessage(objName, funcName, "Hello");
```

3. AndroidManifest.xml
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.androidsample">

    <application
        android:label="@string/app_name"
        android:supportsRtl="true">

        <activity android:name="com.androidsample.AndroidPlugin">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>


    </application>

</manifest>
```

(2) 유니티
1. Unity의 android을 위한 classes.jar파일을 임포트한다. (Assets/Plugins/Android/)
2. C# 스크립트 작성
```
AndroidJavaClass jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
AndroidJavaObject jo = jc.GetStatic<AndroidJavaObject>("currentActivity");

AndroidJavaObject javaObj = new AndroidJavaObject(package);
javaObj.Call("setUnityActivity", jo);
```

