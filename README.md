# Summary

meta-panda-es-rev-b3 support to work Pandaboard ES Rev.B3.

ES Rev.B3 could not boot Linux for other revision of Pandaborad ES because it used a Elpida memory.

This layer include patches and configs of linux kernel so that works with Elpida memory.

These patches stolen from [https://github.com/RobertCNelson/armv7-multiplatform](https://github.com/RobertCNelson/armv7-multiplatform), very thanks.


## Dependency

This layer depend on [meta-ti](git://git.yoctoproject.org/meta-ti).

# How to use

In order to create the image for Pandaboard ES Rev.B3, set "panda-es-rev-b3" to MACHINE variable such as follows.

```txt
MACHINE ?= "panda-es-rev-b3"
```

