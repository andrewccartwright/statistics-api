# Statistics API

## Using this repository locally
Clone the repository locally and run 
```
./mvnw spring-boot:run
```
in the root directory to start the server on https://localhost:8080

## Endpoints

### Distributions

#### Binomial

$$
F(X) = {n \choose x} p^x q^{n-x}
$$

```
POST /distributions/binomial
```

Sample request body:
```
{
  "n": int,
  "p": double (0 ≤ p ≤ 1),
  "x": int
}
```

Sample response:
```
{
    "P(X > x)": 0.5282199999999999,
    "P(X = x)": 0.30870000000000003,
    "P(X < x)": 0.16308000000000006,
    "P(X ≤ x)": 0.8369199999999999,
    "P(X ≥ x)": 0.4717800000000001
}
```
#### Exponential

$$
F(x) = 1 - e^{-\lambda x}, x \geq 0
$$

```
POST /distributions/exponential
```

Sample request body:
```
{
  "x": double,
  "lambda": double
}
```

Sample response:
```
{
    "P(X > x)": 0.20189651799465547,
    "P(X < x)": 0.7981034820053445
}
```

#### Geometric

$$
F(x) = p q^{x-1}
$$

```
POST /distributions/geometric
```

Sample request body:
```
{
  "x": int,
  "p": double (0 ≤ p ≤ 1),
  "includesSuccess": true
}
```

Sample response:
```
{
    "P(X > x)": 0.9375,
    "P(X = x)": 0.0078125,
    "P(X < x)": 0.0546875,
    "P(X ≤ x)": 0.9453125,
    "P(X ≥ x)": 0.0625
}
```

#### Normal

$$
F(x) = 1/2 \[1 + \text{erf}(\frac{z}{\sqrt{2}})\]
$$

```
POST /distributions/normal
```

Sample request body:
```
{
  "x": double,
  "mean": double,
  "stdev": double
}
```

Sample response:
```
{
  "P(X > x)": 0.9375,
  "P(X = x)": 0.0078125,
  "P(X < x)": 0.0546875,
  "P(X ≤ x)": 0.9453125,
  "P(X ≥ x)": 0.0625
}
```
