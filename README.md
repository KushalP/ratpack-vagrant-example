# ratpack-vagrant-example

This is a demo repository to play with the
[Ratpack](http://ratpack.io/) ecosystem.

## Usage

To use this code locally you'll either need:

1. [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
   and [Gradle](https://gradle.org/); or
2. [VirtualBox](https://www.virtualbox.org/),
   [Vagrant](https://www.vagrantup.com/) and
   [Ansible](http://www.ansible.com/)

### Java 8 and Gradle

To run the tests, run the following:

```bash
$ gradle test
```

### VirtualBox, Vagrant and Ansible

To run the tests, run the following:

```bash
$ vagrant up
$ vagrant ssh
$ cd /vagrant
$ gradle test
```
