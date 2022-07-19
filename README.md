# HayuJek API

## Base url

```
https://hayujek-api.herokuapp.com
```

## Table endpoints
### HayuJek

| Name                  | Endpoint                      | Method | Auth token   | Body and response                            |
|-----------------------|-------------------------------|--------|--------------|----------------------------------------------|
| Login Customer        | `/v1/api/customer/login`      | `POST` | no           | [example](#hayujek---login-customer)         |
| Register Customer     | `/v1/api/customer/register`   | `POST` | no           | [example](#hayujek---register-customer)      |
| Get Customer by name  | `/v1/api/customer/{name}`     | `GET`  | yes          | [example](#hayujek---get-customer-by-name)   |
| Get Customer by token | `/v1/api/customer`            | `GET`  | yes          | [example](#hayujek---get-customer-use-token) |
| Login Driver          | `/v1/api/driver/login`        | `POST` | no           | [example](#hayujek---login-driver)           |
| Register Driver       | `/v1/api/driver/register`     | `POST` | no           | [example](#hayujek---register-driver)        |
| Get Driver by name    | `/v1/api/driver/{name}`       | `GET`  | yes          | [example](#hayujek---get-driver-by-name)     |
| Get Driver by token   | `/v1/api/driver`              | `GET`  | yes          | [example](#hayujek---get-driver-use-token)   |
| Search Location       | `/v1/api/location/search`     | `GET`  | no           | [example](#hayujek---location-search)        |
| Reserve Location      | `/v1/api/location/reserve`    | `GET`  | no           | [example](#hayujek---location-reserve)       |
| Routes Location       | `/v1/api/location/routes`     | `GET`  | no           | [example](#hayujek---location-routes)        |

## Run on localhost
- Run `./gradlew bootRun`

---

### HayuJek - Login Customer

```
POST /v1/api/customer/login
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhMmFlMDAxYi1hM2QwLTRlMTUtOGMxZC00MThlZjRkZDBjMTgiLCJhdXRoIjpbImx1a21hbiJdLCJleHAiOjE2NTcxMDQyMzN9.s66R5gO9NeJC5AtqfVHLmOgShFukaAYlrimxk1Kc0Tc",
    "name": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Register Customer

```
POST /v1/api/customer/register
```
Request
```json
{
  "username" : "alex",
  "password" : "123456"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### HayuJek - Get Customer By Name

```
GET /v1/api/customer/:name
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....

```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Get Customer Use Token

```
GET /v1/api/customer
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Login Driver

```
POST /v1/api/driver/login
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhMmFlMDAxYi1hM2QwLTRlMTUtOGMxZC00MThlZjRkZDBjMTgiLCJhdXRoIjpbImx1a21hbiJdLCJleHAiOjE2NTcxMDQyMzN9.s66R5gO9NeJC5AtqfVHLmOgShFukaAYlrimxk1Kc0Tc",
    "name": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Register Driver

```
POST /v1/api/driver/register
```
Request
```json
{
  "username" : "alex",
  "password" : "123456"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### HayuJek - Get Driver By Name

```
GET /v1/api/driver/:name
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....

```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "driver"
  }
}
```

### HayuJek - Get Driver Use Token

```
GET /v1/api/driver
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "driver"
  }
}
```

### HayuJek - Location-Search

```
GET /v1/api/location/search
```
Request
```json
{
  "coordinate" : "-6.1660489,106.8296376",
  "limit" : "20",
  "name" : "cafe"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": [
    {
      "name": "Warju",
      "address": {
        "city": "Jakarta Pusat",
        "country": "Indonesia",
        "distric": "Gambir"
      },
      "coordinate": {
        "latitude": -6.16614,
        "longitude": 106.83023
      }
    },
    {
      "name": "Spinelli Coffee",
      "address": {
        "city": "Jakarta Pusat",
        "country": "Indonesia",
        "distric": "Gambir"
      },
      "coordinate": {
        "latitude": -6.16543,
        "longitude": 106.82967
      }
    },
    {
      "name": "Kedai Kopi Kulo Stasiun Juanda",
      "address": {
        "city": "Jakarta Pusat",
        "country": "Indonesia",
        "distric": "Sawah Besar"
      },
      "coordinate": {
        "latitude": -6.16585,
        "longitude": 106.83048
      }
    },
    {
      "name": "Warkop Mba Yuni",
      "address": {
        "city": "Jakarta Pusat",
        "country": "Indonesia",
        "distric": "Gambir"
      },
      "coordinate": {
        "latitude": -6.16537,
        "longitude": 106.82909
      }
    },
    {
      "name": "Kopi Kenangan",
      "address": {
        "city": "Jakarta Pusat",
        "country": "Indonesia",
        "distric": "Sawah Besar"
      },
      "coordinate": {
        "latitude": -6.1672,
        "longitude": 106.83071
      }
    }
  ]
}
```

### HayuJek - Location-Reserve

```
GET /v1/api/location/reserve
```
Request
```json
{
  "coordinate" : "-6.1660489,106.8296376"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "name": "6, Jalan Juanda 1B, Jakarta Pusat 10120, Indonesia",
    "address": {
      "city": "Jakarta Pusat",
      "country": "Indonesia",
      "distric": "Gambir"
    },
    "coordinate": {
      "latitude": -6.16614,
      "longitude": 106.82966
    }
  }
}
```

### HayuJek - Location-Routes

```
GET /v1/api/location/routes
```
Request
```json
{
  "origin" : "-6.1623528,106.8224898",
  "destination" : "-6.1660489,106.8296376"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "route": [
      {
        "latitude": -6.16262,
        "longitude": 106.822536
      },
      {
        "latitude": -6.16272,
        "longitude": 106.82195
      },
      {
        "latitude": -6.16282,
        "longitude": 106.82143
      },
      {
        "latitude": -6.16351,
        "longitude": 106.82155
      },
      {
        "latitude": -6.16328,
        "longitude": 106.82337
      },
      {
        "latitude": -6.16377,
        "longitude": 106.82341
      },
      {
        "latitude": -6.16398,
        "longitude": 106.82342
      },
      {
        "latitude": -6.16457,
        "longitude": 106.82345
      },
      {
        "latitude": -6.16517,
        "longitude": 106.82351
      },
      {
        "latitude": -6.16554,
        "longitude": 106.82353
      },
      {
        "latitude": -6.16716,
        "longitude": 106.82364
      },
      {
        "latitude": -6.16706,
        "longitude": 106.82452
      },
      {
        "latitude": -6.16704,
        "longitude": 106.82481
      },
      {
        "latitude": -6.16704,
        "longitude": 106.82503
      },
      {
        "latitude": -6.16705,
        "longitude": 106.82537
      },
      {
        "latitude": -6.16706,
        "longitude": 106.82547
      },
      {
        "latitude": -6.16706,
        "longitude": 106.82557
      },
      {
        "latitude": -6.16709,
        "longitude": 106.82583
      },
      {
        "latitude": -6.16717,
        "longitude": 106.8264
      },
      {
        "latitude": -6.16724,
        "longitude": 106.82665
      },
      {
        "latitude": -6.16725,
        "longitude": 106.82669
      },
      {
        "latitude": -6.16732,
        "longitude": 106.82706
      },
      {
        "latitude": -6.16738,
        "longitude": 106.82735
      },
      {
        "latitude": -6.16742,
        "longitude": 106.82756
      },
      {
        "latitude": -6.16746,
        "longitude": 106.82777
      },
      {
        "latitude": -6.16747,
        "longitude": 106.82785
      },
      {
        "latitude": -6.16758,
        "longitude": 106.82835
      },
      {
        "latitude": -6.16781,
        "longitude": 106.82934
      },
      {
        "latitude": -6.16794,
        "longitude": 106.82986
      },
      {
        "latitude": -6.16796,
        "longitude": 106.82997
      },
      {
        "latitude": -6.168,
        "longitude": 106.83028
      },
      {
        "latitude": -6.16765,
        "longitude": 106.83031
      },
      {
        "latitude": -6.16694,
        "longitude": 106.8303
      },
      {
        "latitude": -6.16625,
        "longitude": 106.83024
      },
      {
        "latitude": -6.16628,
        "longitude": 106.82979
      },
      {
        "latitude": -6.166286,
        "longitude": 106.829647
      }
    ]
  }
}
```