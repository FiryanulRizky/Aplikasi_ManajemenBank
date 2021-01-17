-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Jan 2021 pada 10.16
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `nasabah`
--

CREATE TABLE `nasabah` (
  `nasabah_ktp` int(16) NOT NULL,
  `nasabah_nama` varchar(64) NOT NULL,
  `nasabah_tgllahir` date NOT NULL,
  `nasabah_alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nasabah`
--

INSERT INTO `nasabah` (`nasabah_ktp`, `nasabah_nama`, `nasabah_tgllahir`, `nasabah_alamat`) VALUES
(16, 'Cahya', '2018-12-16', 'HH'),
(1604, 'Dharma Sidi', '2018-12-17', 'Jl. Daung 22'),
(1629, 'Wardana', '2018-12-17', 'Jl. Gunung Agung XX'),
(1632, 'Chandra Hendrawan', '2018-12-12', 'Jl. Perum Permain Dalung 73');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rekening`
--

CREATE TABLE `rekening` (
  `rekening_nomor` int(16) NOT NULL,
  `rekening_saldo` bigint(20) DEFAULT NULL,
  `nasabah_ktp` int(16) DEFAULT NULL,
  `rekening_jenis` varchar(64) NOT NULL,
  `rekening_poin` bigint(20) DEFAULT NULL,
  `waktu_buat` date NOT NULL,
  `waktu_bayar` date NOT NULL,
  `waktu_bunga` date NOT NULL,
  `waktu_poin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rekening`
--

INSERT INTO `rekening` (`rekening_nomor`, `rekening_saldo`, `nasabah_ktp`, `rekening_jenis`, `rekening_poin`, `waktu_buat`, `waktu_bayar`, `waktu_bunga`, `waktu_poin`) VALUES
(34328, 100000, 1604, 'Biasa', 0, '2018-12-17', '2018-12-17', '2018-12-17', '2018-12-17'),
(42768, 440000, 16, 'Biasa', 0, '2018-12-16', '2018-12-16', '2018-12-16', '2018-12-16'),
(95003, 0, 1629, 'Biasa', 0, '2018-12-17', '2018-12-17', '2018-12-17', '2018-12-17');

-- --------------------------------------------------------

--
-- Struktur dari tabel `teller`
--

CREATE TABLE `teller` (
  `teller_ktp` int(11) NOT NULL,
  `teller_nama` varchar(64) NOT NULL,
  `teller_username` varchar(64) NOT NULL,
  `teller_password` varchar(64) NOT NULL,
  `teller_ttl` date NOT NULL,
  `teller_alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `teller`
--

INSERT INTO `teller` (`teller_ktp`, `teller_nama`, `teller_username`, `teller_password`, `teller_ttl`, `teller_alamat`) VALUES
(1631, 'Udayana', 'admin2', 'root2', '2018-12-18', 'Jl. Haji Makmur 29'),
(1635, 'Firyanul Rizky', 'admin1', 'root1', '2018-12-01', 'Jl. Haji Makmur 29');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `transaksi_nomor` int(16) NOT NULL,
  `transaksi_jenis` varchar(64) DEFAULT NULL,
  `teller_ktp` int(16) DEFAULT NULL,
  `transaksi_nominal` bigint(20) DEFAULT NULL,
  `transaksi_tanggal` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `rekening_nomor` int(16) NOT NULL,
  `transaksi_debit` varchar(64) DEFAULT NULL,
  `transaksi_kredit` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`transaksi_nomor`, `transaksi_jenis`, `teller_ktp`, `transaksi_nominal`, `transaksi_tanggal`, `rekening_nomor`, `transaksi_debit`, `transaksi_kredit`) VALUES
(1, 'Debit', 1635, 10000, '2018-12-17 02:54:31', 42768, NULL, NULL),
(2, 'Debit', 1635, 15000, '2018-12-17 03:01:20', 42768, NULL, NULL),
(3, 'Debit', 1635, 7000, '2018-12-17 03:07:25', 42768, NULL, NULL),
(4, 'Debit', 1635, 1000, '2018-12-17 03:08:39', 42768, NULL, NULL),
(5, 'Debit', 1635, 14000, '2018-12-17 03:09:50', 42768, NULL, NULL),
(6, 'Debit', 1635, 10000, '2018-12-17 04:03:01', 42768, NULL, NULL),
(7, 'Debit', 1635, 11000, '2018-12-17 04:03:48', 42768, NULL, NULL),
(8, 'Debit', 1635, 100000, '2018-12-17 04:07:55', 42768, NULL, NULL),
(9, 'Debit', 1635, 10000, '2018-12-17 04:08:10', 42768, NULL, NULL),
(10, 'Debit', 1635, 10000, '2018-12-17 04:09:05', 42768, NULL, NULL),
(11, 'Debit', 1635, 10000, '2018-12-17 04:09:54', 42768, NULL, NULL),
(12, 'Debit', 1635, 10000, '2018-12-17 04:12:46', 42768, NULL, NULL),
(13, 'Debit', 1635, 15000, '2018-12-17 04:13:47', 42768, NULL, NULL),
(14, 'Debit', 1635, 20000, '2018-12-17 04:16:20', 42768, NULL, NULL),
(15, 'Debit', 1635, 100000, '2018-12-17 04:26:21', 42768, NULL, NULL),
(16, 'Debit', 1635, 1000000, '2018-12-17 04:26:57', 42768, NULL, NULL),
(17, 'Debit', 1635, 10000, '2018-12-17 04:27:36', 42768, NULL, NULL),
(18, 'Debit', 1635, 10000, '2018-12-17 04:28:21', 42768, NULL, NULL),
(19, 'Debit', 1635, 10000, '2018-12-17 04:30:47', 42768, NULL, NULL),
(20, 'Debit', 1635, 10000, '2018-12-17 04:31:35', 42768, NULL, NULL),
(21, 'Kredit', 1635, 10000, '2018-12-17 04:34:17', 42768, NULL, NULL),
(22, 'Kredit', 1635, 10000, '2018-12-17 04:35:34', 42768, NULL, NULL),
(23, 'Kredit', 1635, 500000, '2018-12-17 04:35:50', 42768, NULL, NULL),
(24, 'Kredit', 1635, 100000, '2018-12-17 16:07:59', 34328, NULL, NULL),
(25, 'Kredit', 1635, 100000, '2018-12-17 16:08:07', 34328, NULL, NULL),
(26, 'Kredit', 1635, 100000, '2018-12-17 16:09:46', 34328, NULL, NULL),
(27, 'Kredit', 1635, 100000, '2018-12-17 16:10:05', 34328, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`nasabah_ktp`);

--
-- Indeks untuk tabel `rekening`
--
ALTER TABLE `rekening`
  ADD PRIMARY KEY (`rekening_nomor`);

--
-- Indeks untuk tabel `teller`
--
ALTER TABLE `teller`
  ADD PRIMARY KEY (`teller_ktp`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`transaksi_nomor`),
  ADD KEY `teller_ktp` (`teller_ktp`),
  ADD KEY `rekening_nomor` (`rekening_nomor`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `transaksi_nomor` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`teller_ktp`) REFERENCES `teller` (`teller_ktp`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`rekening_nomor`) REFERENCES `rekening` (`rekening_nomor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
