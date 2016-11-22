Bilyoner Betting Spec
======================

This spec file includes some of Bilyoner.com betting scenarios

* User must be logged in

Open Bahis Yap Page
-----------------
tags: routing, iddaa

* Move mouse to hoverable "IDDAA" button
* Validate iddaa dropdown menu opened and "9" element is visible
* Click "Bahis Yap" button
* Validate page url is "https://www.bilyoner.com/iddaa/iddaa-bahis-yap"


Choose Matches
--------------
tags: match, iddaa

iy1 		: ilk yarı sonucu 1
h2			: handikapli mac sonucu 2
ms1 		: Mac sonucu 1
betslip		: Secilen maclarin bilgilerinin gosterildigi kuponum

* Choose one of iy1 bet type randomly from available selections
* Choose one of h2 bet type randomly from available selections
* Choose one of ms1 bet type randomly from available selections
* Choose one of any bet type from mbs3 matches which are available on the Bahis Yap page
* Validate 4 match added to betslip
* Validate Kuponum is opened
* Validate Coupon Header background is green


Play Coupon
-----------
tags: match, iddaa

User must complete previous scenarios successfuly

//* Clickk "Devam Et" button
//* Validate "Oyna" button is visible
//* Validate "Geri Dön" button is visible
//* Validate "Kaydet" button is visible
//* Click "Oyna" button
//* Validate "Kuponunuz başarıyla oynanmıştır." message is visible

Cancel Coupon
-------------
tags: match, iddaa, cancel-coupon

//* Move mouse to Heabım hoverable button
//* Validate Hesabım dropdown menu is opened and "8" element is visible
//* Click "Kuponlarım / Biletlerim" button
//* Validatee page url is "https://www.bilyoner.com/hesabim#/hesabim"
//* Validate "iddaa" tab selected
//* Choose first coupon from coupons list
//* Click iptal et button
//* Validate "Aşağıdaki Kuponlarınız Başarı İle İptal Edilmiştir" message is visible
//* Click Tamam button




