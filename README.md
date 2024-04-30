# LP7DPBO2024C-

## janji

Saya Repan Dhia Nararya NIM [2202331] mengerjakan Latihan Praktikum Desain Pemrograman Berorientasi Objek dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Desain Program
Program ini dibuat dengan java swing GUI, berikut penjelasan mengenai bagian dari programnya

**App.java**: Ini adalah kelas utama yang bertanggung jawab untuk memulai permainan. Kelas ini menciptakan frame awal dengan tombol "Start Game". Ketika tombol ini ditekan, frame awal ditutup dan frame permainan dibuka. Frame permainan ini menambahkan instance dari `FlappyBird` ke dalamnya, yang merupakan panel permainan utama. Dengan demikian, `App.java` bertindak sebagai titik awal untuk permainan dan mengatur transisi dari layar awal ke layar permainan.

**Player.java**: Ini adalah kelas yang mendefinisikan pemain dalam game, dalam hal ini burung dalam Flappy Bird. Kelas ini mencakup atribut seperti posisi, ukuran, gambar, dan kecepatan burung. Kelas ini juga memiliki metode `getBounds()` yang mengembalikan batas persegi panjang dari burung, yang digunakan untuk deteksi tabrakan.

**Pipe.java**: Ini adalah kelas yang mendefinisikan pipa dalam game. Pipa adalah rintangan yang harus dihindari oleh pemain. Seperti `Player`, `Pipe` juga memiliki atribut seperti posisi, ukuran, gambar, dan kecepatan. Kelas ini juga memiliki metode `getBounds()` yang mengembalikan batas persegi panjang dari pipa, yang digunakan untuk deteksi tabrakan.

**FlappyBird.java**: Ini adalah kelas utama yang mengatur logika permainan. Kelas ini menciptakan dan mengatur pemain dan pipa, mengatur gambar latar belakang dan gambar burung dan pipa, mengatur timer untuk loop game dan cooldown pipa, mendefinisikan metode untuk gerakan, penempatan pipa, pengecekan tabrakan, pengecekan skor, dan restart game, dan mendefinisikan listener kunci untuk interaksi pengguna. Kelas ini juga ditambahkan ke jendela aplikasi oleh kelas `App`.

## Alur Program
1. Program dimulai dengan kelas App.java. Kelas ini menciptakan frame awal dengan tombol “Start Game”. Frame ini ditampilkan kepada pengguna saat program pertama kali dijalankan.
2. Ketika pengguna menekan tombol “Start Game”, frame awal ditutup dan frame permainan dibuka. Frame permainan ini menambahkan instance dari FlappyBird ke dalamnya.
3. Dalam kelas FlappyBird, pemain dan pipa dibuat dan gambar latar belakang serta gambar burung dan pipa diatur. Timer juga diatur untuk loop game dan cooldown pipa.
4. Selama permainan berlangsung, metode move(), checkCollision(), dan checkScore() dipanggil secara berulang-ulang dalam setiap iterasi dari loop game. Metode move() menggerakkan burung dan pipa, checkCollision() memeriksa apakah ada tabrakan antara burung dan pipa atau burung dan batas bawah frame, dan checkScore() memeriksa apakah burung telah melewati pipa dan menambahkan skor jika ya.
5. Pengguna dapat berinteraksi dengan permainan melalui keyboard. Jika pengguna menekan tombol spasi, burung akan melompat. Jika pengguna menekan tombol ‘R’ setelah game over, permainan akan di-restart.
6. Jika terjadi tabrakan, permainan berakhir. Loop game dan cooldown pipa dihentikan dan pesan “Game Over” ditampilkan.
7. Jika pengguna menekan tombol ‘R’ setelah game over, permainan akan di-restart. Pemain dan pipa dibuat ulang, skor di-reset, dan loop game dan cooldown pipa dimulai lagi.

## Dokumentasi Program


https://github.com/RepanDh/LP7DPBO2024C-/assets/133224998/2c31328c-87e0-4e5d-afd3-f43ec5fcd6e5

