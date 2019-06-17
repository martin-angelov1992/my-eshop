# my-eshop
An eShop application using Spring Boot and JWT. Authenticate with one of those users:

Username: employee<br/>
Password: password

Username: affiliate<br/>
Password: password

Username: oldTimeEmployee<br/>
Password: password

using this URL: http://localhost:8080/auth/signin
then, using the JWT token, you can calculate your discount calling this URL: http://localhost:8080/bill
Here is an example input to the URL:
```json
{
  "products": [{
    "type": "GROCERIES",
    "price": 140
  },
  {
    "type": "OTHER",
    "price": 160
  }]
}
```
Depending on the user you're using, as response you will receive your discounted bill.
