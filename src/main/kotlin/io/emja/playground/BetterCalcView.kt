package io.emja.server

import org.springframework.web.bind.annotation.*

/**
 * Controller class information purposes.
 */
@RestController
@RequestMapping("/calc")
class BetterCalcView(val calculatorService: CalculatorService) {

    @GetMapping("/form")
    fun showForm(): String {
        return """
            <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1f4037, #99f2c8);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        form {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.37);
            width: 100%;
            max-width: 400px;
        }

        label {
            font-size: 1.2em;
            margin-bottom: 8px;
            display: block;
            text-align: left;
        }

        input {
            font-size: 1.2em;
            padding: 12px;
            width: 100%;
            margin-bottom: 20px;
            border: none;
            border-radius: 6px;
            box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
            background: rgba(255, 255, 255, 0.9);
            color: #333;
        }

        input:focus {
            outline: none;
            box-shadow: inset 0 0 5px rgba(0, 123, 255, 0.5);
        }

        button {
            font-size: 1.2em;
            padding: 12px 20px;
            background-color: #2b7a6b; /* Adjusted to match the gradient */
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #236a5a; /* Darker shade of the button color for hover */
        }

        @media (max-width: 480px) {
            h1 {
                font-size: 2em;
            }

            form {
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <form action="/calc/calculate" method="post">
        <h1>Calculator</h1>
        <label for="operation">Enter Operation:</label>
        <input type="text" id="operation" name="operation" required>
        <button type="submit">Calculate</button>
    </form>
</body>
</html>

        """.trimIndent()
    }

    @PostMapping("/calculate")
    fun calculate(@RequestParam operation: String): String {

        val result = calculatorService.performCalculation(calculatorService.splitOperation(operation)[0].toFloat(), calculatorService.splitOperation(operation)[1].toFloat(), calculatorService.splitOperation(operation)[2])
        return """
            <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculation Result</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1f4037, #99f2c8);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 50px;
        }

        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
            color: #fff;
        }

        .result-box {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.37);
            text-align: center;
            width: 100%;
            max-width: 400px;
        }

        a {
            font-size: 1.2em;
            color: #fff;
            text-decoration: none;
            background-color: #2b7a6b; /* Matching the button color from the form */
            padding: 12px 20px;
            border-radius: 6px;
            display: inline-block;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #236a5a; /* Darker shade for hover */
            color: #fff; /* Ensures text color remains white */
        }
    </style>
</head>
<body>
    <div class="result-box">
        <h1>Result: $result</h1>
        <a href="/calc/form">Back to Calculator</a>
    </div>
</body>
</html>

        """.trimIndent()
    }

}