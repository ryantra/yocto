# Base this image on the core-image-base
require recipes-core/images/core-image-base.bb

# Change root password
inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -p \\\$1\\\$qlOUajsg\\\$STrAiz80xWai4gmEsJpPb. root \
    "

# For producing only "rpi-sdimg" image format    
IMAGE_FSTYPE = "rpi-sdimg"    

# Remove the old builds
RM_OLD_IMAGE = "1"

# Remove the splash screen
IMAGE_FEATURES_remove = "splash"

# Install kernel modules
IMAGE_INSTALL += "kernel-modules"

# Install i2c-tools
IMAGE_INSTALL += "i2c-tools"

# Print this message once do_rootfs() has completed
do_rootfs_append(){
    bb.warn("Sign of life!! Image has freshly built!")
}

# Add support for wifi and bluetooth
IMAGE_INSTALL += "linux-firmware-bcm43455"

# Install ssh
IMAGE_FEATURES += "ssh-server-dropbear"

# Install vim
IMAGE_INSTALL += "vim"

# Install tzdata
IMAGE_INSTALL += "tzdata tzdata-europe"

# Install Networkmanager
IMAGE_INSTALL += "\
   networkmanager \
   networkmanager-nmtui \
   networkmanager-bash-completion \
   "
# Install cpp hello world sources versions
IMAGE_INSTALL += "hello-world-cpp-sources"
