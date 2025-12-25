# Java Port Scanner

## Overview
A custom network vulnerability analysis tool built in Java. It utilizes the `java.net.Socket` library to perform TCP 3-way handshakes, identifying open ports and potential security vulnerabilities on local IP addresses.

## Features
- Scans specific IP addresses for open ports.
- Customizable port range (Start to End).
- Implements socket timeouts for faster scanning performance.
- Identifies "Open" vs "Closed/Filtered" ports.

## Tech Stack
- **Language:** Java (Core)
- **Networking:** java.net.Socket, TCP/IP
- **Concepts:** Exception Handling, Socket Programming, I/O Streams

## How to Run
1. Compile the code: `javac SimplePortScanner.java`
2. Run the application: `java SimplePortScanner`
3. Enter target IP (e.g., `127.0.0.1`) and port range.

## Disclaimer
This tool is for educational purposes only. Do not use on networks without authorization.
