# MxAutoLogin


| Name 	| Description 	|
|--------------	|-----------------------	|
| Author 	| Rionald Chancellor 	|
| Company 	| Orange Leaf Consulting 	|
| Version 	| 1.0 	|
| Package name 	| AutoLogin.mpk 	|

### Description
AutoLogin is a module which enables your Mendix application to login users automatically. This is especially useful if you want to users to be logged in automatically after a new user is created.

### Credits

AutoLogin is a module created with the help from several other projects as an inspiration. Credit to the following:
  - [Erwin 't Hoen](https://github.com/Erwin-t-Hoen) for his work on [Open-Authentication-Module](https://github.com/Erwin-t-Hoen/Open-Authentication-Module). The AutoLogin callback request handler is based from his work.
  - Matt K. Daniels for [his blog post](https://www.mattkdaniels.com/blogs/walkthrough-enabling-autologin-functionality-within-your-mendix-app). The login token used in this module is inspired from his blogpost.
  - [Marcus Groen](https://github.com/mrgroen) for his work on [JavaScript Snippet](https://appstore.home.mendix.com/link/app/43096/Incentro-Business-Acceleration/JavaScript-Snippet). The widget is used to add custom JavaScript to POST a request to the custom request handler with the user's loginToken and refresh the client to allow the application security to update.


### Usage Scenario #1

If your Mendix app allows anonymous users to create a user account, it is impossible for anonymous users to use their account immediately. Instead, they are forced to login again. The flow usually as follows:
1. Anonymous users create a new user account
2. New user account created
3. Anonymous user login with credential
4. New session is created for logged in user

With this modle, step 3 can be eliminated. Once the anonymous user create a new account with their username and password input, simply pass these parameters to the function and the anonymous users will be logged in automatically.

### Usage Scenario #2
If you want your Mendix app to use a custom username field, custom authentication text box which uses a custom attribute as login username.

### Features and limitations
- Supports front request handler. No special security permissions are required since the Core.getUser() function is independent of the security permissions. Simply hook up the module with your application and go.
- The POST request to the custom request handler is synchronous to avoid situation in which the request handler transaction is not completed when the user's refresh is finished. If the request handler transaction is not completed and the user refreshes the app, an error will occur since the security is not updated yet.


### Requirements
- Theoretically works on Mendix 6 or later (implemented on Mendix 7.15.1)
- Anonymous users enabled and ability to register a new user account.
- You need to add the **"autologin/"** request handler on your server. The configuration is system specific. For Mendix Cloud, you can [file a support ticket](https://support.mendix.com/). For Microsoft Windows, you can follow [this guide](https://docs.mendix.com/deployment/on-premises/deploy-mendix-on-microsoft-windows). For other system, you can look at the specific system configuration.

### Installation and configuration
1. Download and import the module to your project
2. Set the module role for anonymous users.
3. Add **ASU_LoginRedirectStartRequestHandler** to the Mendix after startup microflow. The handler value is always set as **"autologin/"**. You can go to the .java file and edit the custom request handler value.
4. If you modify the handler value, then ensure that you also modify the JavaScript snippet as well. By default, the POST request will be sent to **yourmendixapp.com/autologin/**.

### Dependencies
1. org.apache.commons.lang3.jar (included)
2. Community commons module


### Known bugs
- The POST request to the custom request handler is synchronous to avoid situation in which the request handler transaction is not completed when the user's refresh is finished. This may cause the screen to freeze when the browser is waiting for the transaction to complete. If the request handler transaction is not completed and the user refreshes the app, an error will occur since the security is not updated yet. Typically this is not the case for production servers since we have to take into account latency and delays as well. But if you test this with your local server and set the request type to synchronous, then sometimes such errors will occur. For more details, check the documentation for [synchronous and asynchronous requests](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/Synchronous_and_Asynchronous_Requests) 


### FAQ
- You can raise an issue on GitHub, I might be able to answer it if I have the time. Asking on Mendix forum probably won't get you the answer since I don't spend much time there.
- If you have a solution for improvements (more modular handler value modification which is actually quite easy to do, or a better POST request solution) please do let me know so everyone can benefit as well.


