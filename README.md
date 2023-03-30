# Statistics API

The Statistics API is a RESTful API built using Java and Apache Maven that calculates basic statistics for a list of numbers. Users can submit a list of numbers to the API, and the API will return the mean, median, mode, and range of the list.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Installation

To install this project, simply clone the repository:

```
git clone https://github.com/andrewchatch/statistics-api.git
```

Then, use Apache Maven to build the project:

```
mvn package
```


This will create a JAR file in the `target` directory. You can run the JAR file using the following command:

```
java -jar target/statistics-api-1.0-SNAPSHOT.jar
```


## Usage

After building and running the JAR file, you can use a tool like `curl` or `Postman` to interact with the API endpoints.

## API Endpoints

The Statistics API currently supports the following endpoints:

### Distributions

#### POST /distributions/binomial

This endpoint calculates a probability using the binomial distribution.

**Request Body**

```json
{
  "n": 5,
  "x": 3,
  "p": 0.4
}
```

**Sample Response**
```json
{
	"P(X > x)": 0.0870399999999999,
	"P(X = x)": 0.23040000000000005,
	"P(X < x)": 0.6825600000000001,
	"P(X ≤ x)": 0.31743999999999994,
	"P(X ≥ x)": 0.9129600000000001
}
```

#### POST /distributions/normal

This endpoint calculates a probability using the normal distribution.

**Request Body**
```json
{
    "x": 10,
    "popMean": 15,
    "popStDev": 6
}
```

**Sample Response**
```json
{
	"Z Score": -0.8333333333333334,
	"P(X > x)": 0.7996051529451687,
	"P(X < x)": 0.20039484705483135
}
```

#### POST /distributions/poisson

This endpoint calculates a probability using the poisson distribution.

**Request Body**
```json
{
    "x": 4,
    "lambda": 6
}
```

**Sample Response**
```json
{
	"P(X > x)": 0.7149434996833687,
	"P(X = x)": 0.1338526175399834,
	"P(X < x)": 0.15120388277664792,
	"P(X ≤ x)": 0.848796117223352,
	"P(X ≥ x)": 0.2850565003166313
}
```

#### POST /distributions/exponential

This endpoint calculates a probability using the exponential distribution.

**Request Body**
```json
{
    "x": 0.4,
    "lambda": 4
}
```

**Sample Response**
```json
{
	"P(X > x)": 0.20189651799465547,
	"P(X < x)": 0.7981034820053445
}
```

#### POST /distributions/geometric

This endpoint calculates a probability using the geometric distribution.

**Request Body**
```json
{
    "x": 7,
    "p": 0.5,
    "includesSuccess": true
}
```

**Sample Response**
```json
{
	"P(X > x)": 0.9375,
	"P(X = x)": 0.0078125,
	"P(X < x)": 0.0546875,
	"P(X ≤ x)": 0.9453125,
	"P(X ≥ x)": 0.0625
}
```

### Scores

#### POST /scores/z_score

This endpoint will calculate a Z score based on the input values.

**Request Body**
```json
{
    "x": 4,
    "popMean": 5,
    "popStDev": 0.7
}
```

**Sample Response**
```json
{
	"Z Score": -1.4285714285714286,
	"P(X > x)": 0.9290487150619141,
	"P(X < x)": 0.07095128493808589
}
```

#### POST /scores/t_score

This endpoint will calculate a T score based on the input values.

**Request Body**
```json
{
    "sampleMean": 6,
    "popMean": 10,
    "sampleStDev": 30,
    "sampleSize": 100
}
```

**Sample Response**
```json
{
	"T Score": -1.3333333333333333,
	"P(T < t)": 0.09274117500105655,
	"P(T > t)": 0.9072588249989435
}
```

### Summary Statistics

#### POST /summary_statistics

This endpoind will return 1-var summary statistics calculated for the entered list of numbers.

**Request Body**
```json
{
    "numbers": [1.0,2.0,3,3.6,9,12.4]
}
```

**Sample Response**
```json
{
	"Mean": 5.166666666666667,
	"Minimum": 1.0,
	"Maximum": 12.4,
	"Mode": 1.0,
	"Median": 3.3,
	"Standard Deviation": 4.506735699668516,
	"Sum": 31.0,
	"Count": 6.0,
	"Range": 11.4,
	"Variance": 20.31066666666667
}
```

## Contributing
Contributions to this project are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository
2. Create a new branch (git checkout -b feature/your-feature)
3. Make your changes
4. Commit your changes (git commit -m 'Add some feature')
5. Push to the branch (git push origin feature/your-feature)
6. Create a new Pull Request

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
