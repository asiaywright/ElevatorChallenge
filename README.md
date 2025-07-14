# ElevatorChallenge
# Elevator Simulation (Java Console App)

This Java console application simulates a basic elevator system that can handle both from inside the elevator and from building floors floor requests.

---

## Features

- Simulates an elevator moving between floors 1 and 20.
- Accepts:
  - Internal requests (only allowed from inside elevator).
  - External requests (only allowed from outside elevator).
- Prevents:
  - Duplicate requests.
  - Invalid floor entries.
  - External requests from users already inside the elevator.
- Displays current floor and elevator movement.


---

##  Assumptions

- The elevator serves floors 1 to 20 only.
- A user can't make an external request if already inside the elevator.
- Only one person is considered to be using the elevator at a time.
- Internal stateresets when there are no pending requests.
- Requests are handled in the order they are received.
- If the requested floor is the same as the current floor, it is ignored.



