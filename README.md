# IPCamView  [![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)
An extended ImageView that can stream MJPEG videos.

<img src="https://raw.githubusercontent.com/marcoscgdev/IPCamView/master/device-2018-12-14-230350.png" width="350">

---

## Releases:

#### Current release: 1.0.0.

You can see all the library releases [here](https://github.com/marcoscgdev/IPCamView/releases).

---

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```groovy
implementation 'com.github.marcoscgdev:IPCamView:1.0.0'
```

### Loading a MJPEG stream

 - XML

```xml
<com.marcoscg.ipcamview.IPCamView
    android:id="@+id/ip_cam_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:scaleType="fitCenter"
    app:url="YOUR_STREAM_URL"
    app:interval="1500"/>
```

 - Java

```java
IPCamView ipCamView = findViewById(R.id.ip_cam_view);
ipCamView.setUrl("http://webcam.abaco-digital.es/zuda/image2.jpg");
ipCamView.setInterval(1000); // In milliseconds, default 1000
ipCamView.start();
```

#### NOTE:
The _start()_ method is required in order to start the MJPEG stream. You can also stop the stream by calling the _stop()_ method.

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
Copyright 2018 Marcos Calvo García

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
