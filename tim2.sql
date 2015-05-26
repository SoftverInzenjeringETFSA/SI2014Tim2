-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2015 at 02:27 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tim2`
--

-- --------------------------------------------------------

--
-- Table structure for table `administratorhibernate`
--

CREATE TABLE IF NOT EXISTS `administratorhibernate` (
  `ID` bigint(20) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `LOZINKA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administratorhibernate`
--

INSERT INTO `administratorhibernate` (`ID`, `USERNAME`, `LOZINKA`) VALUES
(1, 'Administrator', '1000:5b42403438376533306562:9a7b0aeaf31e0e3cab91f02558785ed30dfb5c22ece20d8982f17eeb7df57ac5cb13d4f765f87017a8f45673109b80833d5fac6611f3ff9812aba59e68d484fa');

-- --------------------------------------------------------

--
-- Table structure for table `izvjestajodjelahibernate`
--

CREATE TABLE IF NOT EXISTS `izvjestajodjelahibernate` (
  `ID` bigint(20) NOT NULL,
  `ODJEL` bigint(20) DEFAULT NULL,
  `UKUPANBROJTASKOVAODJELA` int(11) DEFAULT NULL,
  `PROJEKAT` bigint(20) DEFAULT NULL,
  `PROCENATZAVRSENOGRADA` double DEFAULT NULL,
  `TROSAK` double DEFAULT NULL,
  `UKUPNOVRIJEMERADA` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_2an0cknl11negh0rprlqdarar` (`ODJEL`),
  KEY `FK_5i5yoikn3a2m6kom15u739t9u` (`PROJEKAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `izvjestajzaposlenikahibernate`
--

CREATE TABLE IF NOT EXISTS `izvjestajzaposlenikahibernate` (
  `ID` bigint(20) NOT NULL,
  `ZAPOSLENIK` bigint(20) DEFAULT NULL,
  `UKUPANBROJTASKOVA` int(11) DEFAULT NULL,
  `DECIMALANPROCENAT` double DEFAULT NULL,
  `PROJEKAT` bigint(20) DEFAULT NULL,
  `PROCENATZAVRSENOGRADA` double DEFAULT NULL,
  `TROSAK` double DEFAULT NULL,
  `UKUPNOVRIJEMERADA` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_mjpb23oqmhb86lnu1bn6ep7hy` (`ZAPOSLENIK`),
  KEY `FK_cmv94a64fxb7koy25b4o592k7` (`PROJEKAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `odjelhibernate`
--

CREATE TABLE IF NOT EXISTS `odjelhibernate` (
  `ID` bigint(20) NOT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `MAKSIMALANBROJRADNIKA` int(11) DEFAULT NULL,
  `ARHIVIRAN` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `odjelhibernate`
--

INSERT INTO `odjelhibernate` (`ID`, `NAZIV`, `MAKSIMALANBROJRADNIKA`, `ARHIVIRAN`) VALUES
(1, 'Odjel1', 20, b'0'),
(2, 'Odjel2', 10, b'1'),
(3, 'Odjel3', 5, b'0'),
(4, 'Odjel4', 10, b'0'),
(5, 'Odjel5', 11, b'1'),
(6, 'Odjel6', 7, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `odjelzaposlenikhibernate`
--

CREATE TABLE IF NOT EXISTS `odjelzaposlenikhibernate` (
  `ID` bigint(20) NOT NULL,
  `ODJEL` bigint(20) DEFAULT NULL,
  `ZAPOSLENIKODJELA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_j3o6ew77x4otfj0mt9wa3n88b` (`ODJEL`),
  KEY `FK_bo3ctagc8njoqxh3oohg4knip` (`ZAPOSLENIKODJELA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `odjelzaposlenikhibernate`
--

INSERT INTO `odjelzaposlenikhibernate` (`ID`, `ODJEL`, `ZAPOSLENIKODJELA`) VALUES
(1, 1, 1),
(2, 1, 5),
(3, 1, 10),
(4, 2, 1),
(5, 2, 9),
(6, 3, 2),
(7, 3, 4),
(8, 3, 6),
(9, 3, 7),
(10, 4, 8),
(11, 4, 3),
(12, 4, 9),
(13, 5, 3),
(14, 5, 10),
(15, 6, 7);

-- --------------------------------------------------------

--
-- Table structure for table `projekathibernate`
--

CREATE TABLE IF NOT EXISTS `projekathibernate` (
  `ID` bigint(20) NOT NULL,
  `KOORDINATOR` bigint(20) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `NAZIVKLIJENTA` varchar(255) DEFAULT NULL,
  `ARHIVIRAN` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_fsvssvmwo2nvjmohsgqy7k7he` (`KOORDINATOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projekathibernate`
--

INSERT INTO `projekathibernate` (`ID`, `KOORDINATOR`, `NAZIV`, `NAZIVKLIJENTA`, `ARHIVIRAN`) VALUES
(1, 2, 'Projekat1', 'Klijent1', b'0'),
(2, 10, 'Zanimljiv projekat', 'Si-Profesor', b'0'),
(3, 10, 'Tezak projekat', 'Klijent Klijentic', b'1'),
(4, 6, 'Si-projekat2', 'Si-Profesor', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `taskhibernate`
--

CREATE TABLE IF NOT EXISTS `taskhibernate` (
  `ID` bigint(20) NOT NULL,
  `ZAPOSLENIK` bigint(20) DEFAULT NULL,
  `PRIORITET` int(11) DEFAULT NULL,
  `PROCENATZAVRSENOSTI` int(11) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `OPIS` varchar(255) DEFAULT NULL,
  `KOMENTAR` varchar(255) DEFAULT NULL,
  `ROK` tinyblob,
  `PROJEKAT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_qsl58wnc8a0uemwby60desyp6` (`ZAPOSLENIK`),
  KEY `FK_l9272el908n174ndjjehfmt40` (`PROJEKAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `taskhibernate`
--

INSERT INTO `taskhibernate` (`ID`, `ZAPOSLENIK`, `PRIORITET`, `PROCENATZAVRSENOSTI`, `NAZIV`, `OPIS`, `KOMENTAR`, `ROK`, `PROJEKAT`) VALUES
(1, 1, 10, 100, 'Zaposlenik dodan', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 1),
(2, 1, 7, 80, 'Task1', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 1),
(3, 1, 6, 40, 'Task2', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 1),
(4, 4, 10, 100, 'Zaposlenik dodan', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 1),
(5, 4, 3, 90, 'Task3', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 1),
(6, 5, 5, 100, 'Zaposlenik dodan', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 2),
(7, 5, 5, 30, 'Task4', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 2),
(8, 5, 5, 50, 'Task5', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 2),
(9, 5, 9, 100, 'Task6', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 2),
(10, 4, 10, 100, 'Zaposlenik dodan', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 2),
(11, 8, 10, 100, 'Zaposlenik dodan', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4),
(12, 8, 4, 80, 'Task7', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4),
(13, 8, 5, 100, 'Task8', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4),
(14, 9, 6, 100, 'Zaposlenik dodan', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4),
(15, 9, 6, 50, 'Task9', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4),
(16, 9, 7, 70, 'Task10', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4),
(17, 9, 9, 90, 'Task11', 'zadatak zaposlenika', NULL, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df060578, 4);

-- --------------------------------------------------------

--
-- Table structure for table `timesheethibernate`
--

CREATE TABLE IF NOT EXISTS `timesheethibernate` (
  `ID` bigint(20) NOT NULL,
  `DATUMSLANJA` tinyblob,
  `BROJRADNIHSATI` int(11) DEFAULT NULL,
  `PROJEKAT` bigint(20) DEFAULT NULL,
  `VALIDIRAN` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_rnx5pbv0ym2bxbsmf8lgju1ua` (`PROJEKAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timesheethibernate`
--

INSERT INTO `timesheethibernate` (`ID`, `DATUMSLANJA`, `BROJRADNIHSATI`, `PROJEKAT`, `VALIDIRAN`) VALUES
(1, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051a78, 7, 1, b'0'),
(2, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051a78, 4, 1, b'1'),
(5, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051a78, 6, 4, b'1'),
(6, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051a78, 1, 2, b'0'),
(7, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051a78, 6, 2, b'0'),
(8, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051878, 5, 4, b'0'),
(9, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051778, 8, 4, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `timesheettaskhibernate`
--

CREATE TABLE IF NOT EXISTS `timesheettaskhibernate` (
  `ID` bigint(20) NOT NULL,
  `TIMESHEET` bigint(20) DEFAULT NULL,
  `TASK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_tl1h9qf6d9wd8vjy7hi2l3gwc` (`TIMESHEET`),
  KEY `FK_4hg575hyd84g8bpnatsin42og` (`TASK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timesheettaskhibernate`
--

INSERT INTO `timesheettaskhibernate` (`ID`, `TIMESHEET`, `TASK`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 3),
(4, 5, 12),
(5, 5, 13),
(6, 6, 4),
(7, 6, 5),
(8, 7, 9),
(9, 8, 15),
(10, 9, 17);

-- --------------------------------------------------------

--
-- Table structure for table `zaposlenikhibernate`
--

CREATE TABLE IF NOT EXISTS `zaposlenikhibernate` (
  `ID` bigint(20) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `LOZINKA` varchar(255) DEFAULT NULL,
  `IME` varchar(255) DEFAULT NULL,
  `PREZIME` varchar(255) DEFAULT NULL,
  `ADRESA` varchar(255) DEFAULT NULL,
  `DATUMZAPOSLENJA` tinyblob,
  `SATNICA` double DEFAULT NULL,
  `ARHIVIRAN` bit(1) DEFAULT NULL,
  `KOORDINATOR` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zaposlenikhibernate`
--

INSERT INTO `zaposlenikhibernate` (`ID`, `USERNAME`, `LOZINKA`, `IME`, `PREZIME`, `ADRESA`, `DATUMZAPOSLENJA`, `SATNICA`, `ARHIVIRAN`, `KOORDINATOR`) VALUES
(1, 'imePrezime', '1000:5b42403333383239353366:f73bcb87b8ee45559c8b9c8db8120609ba831c427661b5840ab441da35ab9e2a93607a520c86340c6331a1c7c1ef449d4da4c26d800b8813c7b735f405e261f0', 'Ime', 'Prezime', 'Adresa 11', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df051a78, 20, b'0', b'0'),
(2, 'ahajdarevic1', '1000:5b424033343139323261:7874fe004a94f4a68f005e75ed09d1fad004cacf99ca787f44e87f634602030a885b8f31a030361333ced3412aefc5b696f67fdbd2c9634a3085411661b295b4', 'Adnan', 'Hajdarevic', 'Adresa 15', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df031a78, 20, b'0', b'1'),
(3, 'mkulovic1', '1000:5b42403635653631343364:c0b6da47667d6bef32c13717763980e2d47ba92fa915933e0804caa8c7122a7ec7f61f97f51cf01dc4a0cf68695c693f88d967ed0cc14e26423ceb810ae03d11', 'Mirsad', 'Kulovic', 'Mahala 25', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007dd091a78, 10, b'1', b'0'),
(4, 'amekovic1', '1000:5b42403263376565376633:6c03a9ca3ba4ccbe8ff57445988929aa6065efa5bff89ed9db6ed0962f6e2158817e50ff2cce34a45afce3f54c3ab9117408d4a212ade23d52cb3a0aaa4ed174', 'Amer', 'Mekovic', 'Mahala 15', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007de071a78, 10, b'0', b'0'),
(5, 'tdajevic1', '1000:5b42403362383266366630:961a38b2075d081f624a5d89ea93b991d15ed3fcfe991a0ecd39dc849324df3f2a9d562e7ae806627388bcb1a6f812d8eff6cc05a92eaed302873eb3b15eaaaa', 'Toni', 'Dajevic', 'Ulica 5', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007de091a78, 8, b'0', b'0'),
(6, 'sdajevic1', '1000:5b42403663353963383465:d11337cadccf40842a01e47974d0a85c3be3994f29625004e34819323a6bdd90f5c63a26c76600c311238e9d076d209d3ff1db1e6db79186b4eb10a9e2b63832', 'Sarma', 'Dajevic', 'Ulica 51', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007de0c1a78, 25, b'0', b'1'),
(7, 'ibikic1', '1000:5b424037386230323836:1319f92b3f32e944c98446b2cc596cedd81a2674ab641c68c50aadfbc5b5eda9f6f861d31b9a1915a4bd92e1834e4df9a648b5ff236764276edab3f399b3d255', 'Irma', 'Bikic', 'Ulica Heroja 23', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007de0c1a78, 12, b'1', b'1'),
(8, 'mnikic1', '1000:5b42403135393337383362:c6def38b4ad5fb0dd0c38b3d91858fbe3f54e73cb757bc90ef47d059ef615de5b3d72f9845cc4115e1d712623beaa38f64e94e4be24da241481ef255fbfacf6d', 'Mirna', 'Nikic', 'Sarajevska ulica 23', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df041578, 11, b'0', b'0'),
(9, 'hnikic1', '1000:5b42403637323634656162:4b6a141a1195338206d7895e43e2d7b2d90446f592a0b1494fb90a0154091c467a575b5aee6789be1bb09f78fdfd5d64101e90b03ed73bd187cac49b9987b005', 'Hamza', 'Nikic', 'Sarajevska ulica 23', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df041578, 11, b'0', b'0'),
(10, 'lfazlic1', '1000:5b42403134636632613935:c991226f49ff7cdd98eaed9912ccd0485b884ecd40a7d8194f0485d7e969bebc5e3d14cdb66453848b94837e7cd4ca9cc497f440addb3b499cb86f71df6b37ec', 'Lejla', 'Fazlic', 'Dobrinja 23', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007df041578, 20, b'0', b'1');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `izvjestajodjelahibernate`
--
ALTER TABLE `izvjestajodjelahibernate`
  ADD CONSTRAINT `FK_5i5yoikn3a2m6kom15u739t9u` FOREIGN KEY (`PROJEKAT`) REFERENCES `projekathibernate` (`ID`),
  ADD CONSTRAINT `FK_2an0cknl11negh0rprlqdarar` FOREIGN KEY (`ODJEL`) REFERENCES `odjelhibernate` (`ID`);

--
-- Constraints for table `izvjestajzaposlenikahibernate`
--
ALTER TABLE `izvjestajzaposlenikahibernate`
  ADD CONSTRAINT `FK_cmv94a64fxb7koy25b4o592k7` FOREIGN KEY (`PROJEKAT`) REFERENCES `projekathibernate` (`ID`),
  ADD CONSTRAINT `FK_mjpb23oqmhb86lnu1bn6ep7hy` FOREIGN KEY (`ZAPOSLENIK`) REFERENCES `zaposlenikhibernate` (`ID`);

--
-- Constraints for table `odjelzaposlenikhibernate`
--
ALTER TABLE `odjelzaposlenikhibernate`
  ADD CONSTRAINT `FK_bo3ctagc8njoqxh3oohg4knip` FOREIGN KEY (`ZAPOSLENIKODJELA`) REFERENCES `zaposlenikhibernate` (`ID`),
  ADD CONSTRAINT `FK_j3o6ew77x4otfj0mt9wa3n88b` FOREIGN KEY (`ODJEL`) REFERENCES `odjelhibernate` (`ID`);

--
-- Constraints for table `projekathibernate`
--
ALTER TABLE `projekathibernate`
  ADD CONSTRAINT `FK_fsvssvmwo2nvjmohsgqy7k7he` FOREIGN KEY (`KOORDINATOR`) REFERENCES `zaposlenikhibernate` (`ID`);

--
-- Constraints for table `taskhibernate`
--
ALTER TABLE `taskhibernate`
  ADD CONSTRAINT `FK_l9272el908n174ndjjehfmt40` FOREIGN KEY (`PROJEKAT`) REFERENCES `projekathibernate` (`ID`),
  ADD CONSTRAINT `FK_qsl58wnc8a0uemwby60desyp6` FOREIGN KEY (`ZAPOSLENIK`) REFERENCES `zaposlenikhibernate` (`ID`);

--
-- Constraints for table `timesheethibernate`
--
ALTER TABLE `timesheethibernate`
  ADD CONSTRAINT `FK_rnx5pbv0ym2bxbsmf8lgju1ua` FOREIGN KEY (`PROJEKAT`) REFERENCES `projekathibernate` (`ID`);

--
-- Constraints for table `timesheettaskhibernate`
--
ALTER TABLE `timesheettaskhibernate`
  ADD CONSTRAINT `FK_4hg575hyd84g8bpnatsin42og` FOREIGN KEY (`TASK`) REFERENCES `taskhibernate` (`ID`),
  ADD CONSTRAINT `FK_tl1h9qf6d9wd8vjy7hi2l3gwc` FOREIGN KEY (`TIMESHEET`) REFERENCES `timesheethibernate` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
