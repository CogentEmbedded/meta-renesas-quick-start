PACKAGECONFIG[drm-gl] = ",,virtual/libgl libdrm libgbm"
PACKAGECONFIG[drm-gles2] = ",,virtual/libgles2 libdrm libgbm"
PACKAGECONFIG[wayland-gl] = ",,virtual/libgl wayland wayland-kms"
PACKAGECONFIG[wayland-gles2] = ",,virtual/libgles2 wayland wayland-kms mesa"

PACKAGECONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'x11-gles2', '', d)} \
                 ${@bb.utils.contains('DISTRO_FEATURES', 'wayland opengl', 'wayland-gles2', '', d)} \
"
