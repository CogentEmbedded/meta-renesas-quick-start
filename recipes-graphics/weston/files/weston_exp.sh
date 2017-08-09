#!/bin/sh

if [ x"$XDG_RUNTIME_DIR" = x ]; then
	export XDG_RUNTIME_DIR=/run/user/root/
        mkdir --parents $XDG_RUNTIME_DIR
        chmod 0700 $XDG_RUNTIME_DIR
fi

if [ x"$XDG_SESSION_TYPE" = x ]; then
        export XDG_SESSION_TYPE=wayland
fi

if [ x"$QT_QPA_PLATFORM" = x ]; then
        export QT_QPA_PLATFORM=wayland
fi
