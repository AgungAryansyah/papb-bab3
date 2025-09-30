## Aplikasi Counter Plus-Minus
Kode menggunakan state count dengan remember { mutableStateOf(0) } untuk menyimpan angka. Terdapat dua tombol, Tambah (+) untuk menaikkan nilai dan Kurang (–) untuk menurunkan nilai. Supaya logis, nilai tidak boleh turun di bawah nol dengan kondisi if (count > 0) count--. State ini memastikan setiap perubahan langsung memicu pembaruan teks jumlah pada layar.

## Tombol Toggle Warna
Menggunakan state isRed dengan remember { mutableStateOf(true) } untuk menentukan warna kotak. Box dibuat dengan ukuran 200×200 dp dan diberi background merah jika isRed bernilai true, atau hijau jika false. Modifier clickable dipakai untuk membalik nilai state setiap kali kotak diklik, sehingga warna terus bergantian merah dan hijau.

## Aplikasi Profil Interaktif
State isFollowed dengan remember { mutableStateOf(false) } digunakan untuk menentukan status Follow atau Unfollow. Profil menampilkan foto dummy, nama, dan deskripsi singkat. Tombol Follow/Unfollow akan mengubah nilai state ketika ditekan, dan teks indikator di bawah tombol menampilkan status: jika true berarti “Anda mengikuti akun ini”, jika false berarti “Anda belum mengikuti akun ini”. State membuat UI langsung berubah sesuai interaksi pengguna.
