# dji-tello-lib
Lib supports basic commands for DJI Tello Drone.

## How to connect
1. turn on drone
2. connect computer wifi with drone wifi

## Supported Commands
- takeoff
- land
- up/down
- left/right
- forward/back

## Example
```
TelloCommands commands = TelloCommands.getInstance();
commands.takeoff();
commands.forward(100);
commands.land();
commands.exit();
```
