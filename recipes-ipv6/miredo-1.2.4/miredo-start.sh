#!/bin/sh
killall miredo
sleep 1
killall -9 miredo
sleep 1
/usr/sbin/miredo
