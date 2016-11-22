Bilyoner Login Spec
====================

This spec file includes Bilyoner.com login scenarios


Successful Login
-----------------
tags: login

* Open "https://www.bilyoner.com" on any browser
* Fill user id input with a valid user id
* Fill password input with a valid password
* Click login button

Unsuccessful Login
-----------------
tags: login

* Validate "https://www.bilyoner.com" opened on browser
* Validate there is no logged in user
* Fill user id input with "11111111"
* Fill password input with "111111"
* Click login button
* Validate "Giriş/Şifre bilgileriniz hatalıdır! Lütfen tekrar deneyiniz..." message is visible
* Refresh web page
