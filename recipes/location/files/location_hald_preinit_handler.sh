#!/bin/sh
#
# Copyright (c) 2020, The Linux Foundation. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are
# met:
#    # Redistributions of source code must retain the above copyright
#       notice, this list of conditions and the following disclaimer.
#    # Redistributions in binary form must reproduce the above
#       copyright notice, this list of conditions and the following
#       disclaimer in the documentation and/or other materials provided
#       with the distribution.
#    # Neither the name of The Linux Foundation, nor the names of its
#       contributors may be used to endorse or promote products derived
#       from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESS OR IMPLIED
# WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT
# ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
# BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
# CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
# SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
# BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
# WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
# OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
# IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
# location_hald_preinit_handler.sh:
# Delete the external ap local files on every reboot of mdm.
# Invoke before loc hal daemon is launched
#

# $1 - msg to print
function printToKernelMsg()
{
    echo "lochald:  $1"|tee /dev/kmsg
}

wait_for_dir_mount() {
    while ! [ -d /var/tmp ]
    do
        printToKernelMsg "waiting for /var to mount"
    done
    while ! [ -d /data ]
    do
        printToKernelMsg "waiting for /data to mount"
    done
}

# for location hal daemon
printToKernelMsg "Starting location_hald_preinit_handler.sh. Pid: $$."

# wait for dirs
wait_for_dir_mount
TMP_LOC_DIR="/var/tmp/location"
TMP_LOC_HALD_TRACK_FILE="$TMP_LOC_DIR/.location_hald"
if ! [ -e $TMP_LOC_HALD_TRACK_FILE ]
then
    if ! [ -d $TMP_LOC_DIR ]
    then
        printToKernelMsg "$TMP_LOC_DIR not available yet"
        mkdir $TMP_LOC_DIR
    fi
    # create a tracking file in temp folder
    touch $TMP_LOC_HALD_TRACK_FILE
    printToKernelMsg "Pre starting location hal daemon: $?"
    printToKernelMsg "Pre - num of files in extap_locclient - "$(ls /data/vendor/location/extap_locclient/|wc -l)""
    rm /data/vendor/location/extap_locclient/*
    printToKernelMsg "Deleting all extap local files : $?"
    printToKernelMsg "Post - num of files in extap_locclient - "$(ls /data/vendor/location/extap_locclient/|wc -l)""
else
    printToKernelMsg "location hal daemon has already started."
fi
printToKernelMsg "Completed location_hald_preinit_handler.sh"
exit 0
