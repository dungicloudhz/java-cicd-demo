# API Reference

Base URL: `http://localhost:8080`

## App Info

```bash
curl http://localhost:8080/
```

## Health Check

```bash
curl http://localhost:8080/actuator/health
```

## Products

**GET all products**
```bash
curl http://localhost:8080/api/products
```

**GET product by ID**
```bash
curl http://localhost:8080/api/products/1
```

**POST create product**
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name": "Monitor", "price": 299.99}'
```

**DELETE product**
```bash
curl -X DELETE http://localhost:8080/api/products/1
```
