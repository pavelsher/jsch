# Fork of JSch-0.1.55

See original [README](README)

[![GitHub release](https://img.shields.io/github/v/tag/mwiede/jsch.svg)](https://github.com/mwiede/jsch/releases/latest)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.mwiede/jsch/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.mwiede/jsch)
![Java CI with Maven](https://github.com/mwiede/jsch/workflows/Java%20CI%20with%20Maven/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mwiede_jsch&metric=alert_status)](https://sonarcloud.io/dashboard?id=mwiede_jsch)

## Why should you use this library?

As I explained in a [blog post](http://www.matez.de/index.php/2020/06/22/the-future-of-jsch-without-ssh-rsa/) the main points are:
* OpenSSH will disable ssh-rsa in the future per default and you need a library which supports rsa-sha2-256 and rsa-sha2-512.
* Drop in replacement: just change dependency coordinates and you are good to go.
* No active maintenance of [JSch at SourceForge](https://sourceforge.net/projects/jsch/).
* Stay in sync with OpenJDK features so there is no need for additional dependencies.

## FAQ

* Is this fork 100% compatible with original JSch, because the connection to my server does not work any more!
  * For compatibility with OpenSSH and improved security, the order of crypto algorithms was changed. If you still want to use older or deprecated algorithms, you need to change the configuration. Examples see [#37](https://github.com/mwiede/jsch/issues/37), [#40](https://github.com/mwiede/jsch/issues/40)
  * To make it easier to adjust the crypto algorithms, starting with [0.1.65](https://github.com/mwiede/jsch/releases/tag/jsch-0.1.65) the following system properties can be set at your application's startup:
    * `jsch.kex`
      * analogous to `JSch.setConfig("kex", "...")`
    * `jsch.server_host_key`
      * analogous to `JSch.setConfig("server_host_key", "...")`
    * `jsch.prefer_known_host_key_types`
      * analogous to `JSch.setConfig("prefer_known_host_key_types", "...")`
    * `jsch.enable_server_sig_algs`
      * analogous to `JSch.setConfig("enable_server_sig_algs", "...")`
    * `jsch.cipher`
      * analogous to `JSch.setConfig("cipher.s2c", "...")` + `JSch.setConfig("cipher.c2s", "...")`
    * `jsch.mac`
      * analogous to `JSch.setConfig("mac.s2c", "...")` + `JSch.setConfig("mac.c2s", "...")`
    * `jsch.compression`
      * analogous to `JSch.setConfig("compression.s2c", "...")` + `JSch.setConfig("compression.c2s", "...")`
    * `jsch.lang`
      * analogous to `JSch.setConfig("lang.s2c", "...")` + `JSch.setConfig("lang.c2s", "...")`
    * `jsch.dhgex_min`
      * analogous to `JSch.setConfig("dhgex_min", "...")`
    * `jsch.dhgex_max`
      * analogous to `JSch.setConfig("dhgex_max", "...")`
    * `jsch.dhgex_preferred`
      * analogous to `JSch.setConfig("dhgex_preferred", "...")`
    * `jsch.compression_level`
      * analogous to `JSch.setConfig("compression_level", "...")`
    * `jsch.preferred_authentications`
      * analogous to `JSch.setConfig("PreferredAuthentications", "...")`
    * `jsch.client_pubkey`
      * analogous to `JSch.setConfig("PubkeyAcceptedAlgorithms", "...")`
    * `jsch.check_ciphers`
      * analogous to `JSch.setConfig("CheckCiphers", "...")`
    * `jsch.check_macs`
      * analogous to `JSch.setConfig("CheckMacs", "...")`
    * `jsch.check_kexes`
      * analogous to `JSch.setConfig("CheckKexes", "...")`
    * `jsch.check_signatures`
      * analogous to `JSch.setConfig("CheckSignatures", "...")`
    * `jsch.fingerprint_hash`
      * analogous to `JSch.setConfig("FingerprintHash", "...")`
    * `jsch.max_auth_tries`
      * analogous to `JSch.setConfig("MaxAuthTries", "...")`
* Are ssh-ed25519, ssh-ed448, curve25519-sha256, curve448-sha512 & chacha20-poly1305@<!-- -->openssh.com supported?
  * This library is a Multi-Release-jar, which means that you can only use certain features when a more recent Java version is used.
    * In order to use ssh-ed25519 & ssh-ed448, you must use at least Java 15.
    * In order to use curve25519-sha256, curve448-sha512 & chacha20-poly1305@<!-- -->openssh.com, you must use at least Java 11.
  * As of the [0.1.66](https://github.com/mwiede/jsch/releases/tag/jsch-0.1.66) release, these algorithms can now be used with older Java releases if [Bouncy Castle](https://www.bouncycastle.org/) (bcprov-jdk15on) is added to the classpath.

## Changes since fork:
See [ChangeLog.md](ChangeLog.md)
