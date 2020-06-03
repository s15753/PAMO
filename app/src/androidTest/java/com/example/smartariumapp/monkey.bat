E:
cd E:\PJATK\pamo_project\platform-tools
.\adb shell am start -n com.example.smartariumapp/.ui.login.LoginActivity
.\adb shell input text 'jan_nowak'
.\adb shell input keyevent 61
.\adb shell input text 'vn2ee#4QEtqa'
.\adb shell input keyevent 61
.\adb shell input keyevent 66
.\adb shell monkey -p com.example.smartariumapp -c android.intent.category.MONKEY -v 2500
pause