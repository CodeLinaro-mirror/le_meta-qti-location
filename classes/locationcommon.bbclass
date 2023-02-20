## Copyright (c) 2021 The Linux Foundation. All rights reserved.
##
## Redistribution and use in source and binary forms, with or without
## modification, are permitted provided that the following conditions are
## met:
##     * Redistributions of source code must retain the above copyright
##       notice, this list of conditions and the following disclaimer.
##     * Redistributions in binary form must reproduce the above
##       copyright notice, this list of conditions and the following
##       disclaimer in the documentation and/or other materials provided
##       with the distribution.
##     * Neither the name of The Linux Foundation nor the names of its
##       contributors may be used to endorse or promote products derived
##       from this software without specific prior written permission.
##
## THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESS OR IMPLIED
## WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
## MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT
## ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
## BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
## CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
## SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
## BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
## WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
## OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
## IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

## Bitbake class to keep location common functionalities.

## util function to add a config details based on whether target is
## in list or not
def loc_target_in_list(list, prependstr, truestr, falsestr, d):
    # bb.note("target_in_list")
    target_set = set(d.getVar('BASEMACHINE', True).split())
    # bb.note("target_set :" + str(target_set))
    check_set = set(list.split())
    # bb.note("check_set :" + str(check_set))
    if target_set & check_set:
        return prependstr+truestr
    else:
        return prependstr+falsestr

# return yes if target supports modem, else no
def is_modem_supported_target(d):
    return loc_target_in_list('kalama', '', 'no', 'yes', d)

## util function to get the OECONF for modem support availablity
def oe_conf_modem_enabled_target(d):
    if is_modem_supported_target(d) == 'yes':
        # bb.note("oe_conf_modem_enabled_target : yes")
        return '--with-modem-support=yes'
    else:
        # bb.note("oe_conf_modem_enabled_target : no")
        return '--with-modem-support=no'

## util function to get the CFLAGS append for modem support unavailability.
def cflags_modem_disabled_target(d):
    if is_modem_supported_target(d) == 'no':
        # bb.note("cflags_modem_disabled_target : no")
        return ' -DNO_MODEM_TARGET'
    else:
        return " "