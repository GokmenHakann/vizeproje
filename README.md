# vizeproje
Selamlar, Üniversitede İleri Java Dersinde yapmış olduğum projemde spring boot üzerinden maven projesi oluşturdum ve buradan Get restful servisleri yazdım bu servisleri test edebilmek için de Swagger-ui kullandım.
Projemdeki işlemler sırasıyla şu şekildedir : 

1-) Girilmiş olan cümledeki her bir kelimeyi size liste olarak return eder.

2-) Girilmiş olan cümledeki en uzun kelimeyi ve karakter sayısını return eder. 

3-) Girilmiş olan sayıyı ters çevirdikten sonra return eder (Ör. 1542 2451).

4-) Girilmiş olan sayı kadar random sayı üretir ve üretilmiş olan sayıları tek ve çift olarak 2 ayrı diziye atar daha sonra bu listelerde 0 var mı diye kontrol eder varsa yeni bir random sayı üretip uygun diziye atıp return eder.

5-) Koninin tabanı ve yüksekliğine göre hacmini hesaplayıp daha sonra onu yuvarlayıp return eder.

6-) Girilen sayıya kadar olan(girilen sayı dahil) faktöriyelleri hesaplar ve "faktoriyel.txt" adlı bir dosyaya yazar ve dosyanın konumunu return eder. 

Projeyi Swagger arayüzünden test etmek için http://localhost:8080/swagger-ui/index.html adresine gidebilirsiniz.
Eğer projeyi normal url üzerinden test etmek isterseniz http://localhost:8080/soru1?cumle=maven%20deneme şeklinde test edebilirsiniz.
