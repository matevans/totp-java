# Java TOTP generator

Example Java code to generate TOTP codes for use on HMRC API Platform

## Usage

Running through the `Makefile` will automatically download dependencies and compile.

### Generate a TOTP with TOTP Secret "TEST"
```
make generate
```
or just
```
make
```

### Generate a TOTP with a specific TOTP Secret
```
make generate SECRET=XXXXXXX
```
or just
```
make SECRET=XXXXXXX
```
