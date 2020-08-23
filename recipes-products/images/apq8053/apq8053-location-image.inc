# location open source packages
IMAGE_INSTALL += "${@base_contains('DISTRO_FEATURES','location-services', 'loc-hal', '', d)}"
