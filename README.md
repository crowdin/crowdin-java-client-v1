### Crowdin API Java SDK

A Java library to access [Crowdin API](https://support.crowdin.com/api/api-integration-setup/).

Crowdin provides RESTful API with XML or JSON over HTTP using GET or POST methods. With a help of this SDK you can smooth the work with all Crowdin API methods in your Java project, such as adding and updating files, downloading translations or integrating localization with your development process.

#### Prerequisites

* Java JDK 7 or newest
* Gradle or Maven

#### Quick start

* Clone the repo
```
git clone https://github.com/crowdin/crowdin-java-sdk.git
```
* Refresh project's dependencies using gradle
* Build the project to get _jar_ file :
```
gradle buildJavaSdkJar
```
* Add this file to your project

#### Acquiring and Using an API Key

To find your project API key you have to:

1. Login to your Crowdin account

2. Select necessary project

3. Go to the Project Settings, API tab

![Settings API](https://support.crowdin.com/assets/docs/settings_api.png)

#### Making First Call

Once you have completed the Installation, we could make the first call:
* Create variables for API key, project identifier, account key, base url and save their values
```
public static final String  BASE_URL = "https://api.crowdin.com/api/";
public static final String  PROJECT_IDENTIFIER = "your-project-identifier";
public static final String  PROJECT_KEY = "your-project-key";
public static final String  ACCOUNT_KEY = "your-account-key";
```
* Create a _Credentials_ object with proper configurations
```
Credentials credentials = new Credentials(BASE_URL, PROJECT_IDENTIFIER, PROJECT_KEY, ACCOUNT_KEY);
```
* Create a _CrowdinApiParametersBuilder_ object and set parameters necessary for chosen method (See the list of [Crowdin API methods and their parameters](https://support.crowdin.com/api/api-integration-setup/))
```
CrowdinApiParametersBuilder parameters = new CrowdinApiParametersBuilder();
parameters.json();
```
* Create _CrowdinApiClient_ object and choose the necessary API method
```
CrowdinApiClient crwdn = new Crwdn();
crwdn.getInfo(credentials, parameters);
```
For output the response's entity:
```
System.out.println(crwdn.getInfo(credentials, parameters).getEntity(String.class));
```
* Run the code using IDE or command line. It should return something like this:
```
{
  "languages":[...],
  "files":[...],
  "details":{
    "source_language":{
      "name":"Ukrainian",
      "code":"uk"
    },
    "name":"crowdin2",
    "identifier":"crowdin2",
    "created":"2016-11-09 07:20:33",
    "description":"",
    "join_policy":"private",
    "last_build":"2016-12-07 10:00:27",
    "last_activity":"2016-12-16 08:53:32",
    "participants_count":"1",
    "total_strings_count":"24",
    "total_words_count":"24",
    "duplicate_strings_count":22,
    "duplicate_words_count":22,
    "invite_url":{
      "translator":"https:\/\/crowdin.com\/project\/crowdin2\/invite?d=b555o4i6o6f5h5b3m4c333453",
      "proofreader":"https:\/\/crowdin.com\/project\/crowdin2\/invite?d=755565j6b6f5h5b3m4c3455323"
    }
  }
}
```

#### Bug tracker
Have a bug? Please create an issue here on [GitHub](https://github.com/crowdin/crowdin-java-sdk/issues)

#### License and Author
Ihor Popyk (ihor.popyk@crowdin.com)

https://github.com/ihor-popyk

Copyright: 2018 crowdin.com

This project is licensed under the MIT license, a copy of which can be found in the LICENSE file.
