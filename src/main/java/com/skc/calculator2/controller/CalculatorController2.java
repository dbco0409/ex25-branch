package com.skc.calculator2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skc.calculator2.dto.CalculationRequest;
import com.skc.calculator2.dto.CalculationResponse;
import com.skc.calculator2.service.CalculatorService2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("calculator2")
public class CalculatorController2 {

//	java방식
//	CalculatorService calculatorService = new CalculatorService();

//	spring방식1: 기본 연결 방식
//	@Autowired
//	CalculatorService calculatorService;

//	spring방식2: 생성자를 통한 객체주입 방식
	CalculatorService2 calculatorService;

	public CalculatorController2(CalculatorService2 calculatorService) {
		this.calculatorService = calculatorService;
	}

//	----- 문자열을 리턴 -----
//	@GetMapping("/add")
//	public String add() {
//		return new String("/덧셈");
//	}
//	----- 더블타입의 연산결과를 리턴 -----
//	@GetMapping("/add")
//	public double add() {
//		return (10 + 5);
//	}
//	----- 오브젝트.메소드: 서비스 로직으로 연산결과를 리턴 -----
//	@GetMapping("/add")
//	public double add() {
//		return calculatorService.add(10,5);
//	}
//	----- 사용자가 입력한 값을 받아서, 서비스 로직으로 연산결과를 리턴 -----
//	@GetMapping("/add")
//	public double add(@RequestParam int num1, @RequestParam int num2) {
//		return calculatorService.add(num1, num2);
//	}
//	----- 1. 결과값: 서비스 로직으로 연산결과를 얻음
//	----- 2. 결과를 출력할 포맷을 dto(recode타입)을 사용하겠다 
//	----- 3. return타입을 dto(recode타입)으로 수정해주자
//	----- 4. 브라우저확인1: http://localhost:8080/calculator/add?num1=20&num2=30
//	-----    브라우저확인2: http://localhost:8090/calculator/add?num1=20&num2=30
	@GetMapping("/add")
	public CalculationResponse add(@RequestParam int num1, @RequestParam int num2) {
		double result = calculatorService.add(num1, num2);
		return new CalculationResponse(num1, num2, "add", result);
	}

//	----- Post메소드테스트: entity문자열을 리턴 -----
//	ENDpoint테스트: http://localhost:8090/calculator/calculate
//	@PostMapping("/calculate")
//	public String postMethodName(@RequestBody String entity) {
//		return entity;
//	}
	
//	----- 1. @RequestBody: 객체 방식으로 값을 저장 -----
//	----- 2. result: 연산 결과값을 저장 -----
//	----- 3. 출력포맷: 객체 방식으로 값을 화면에 뿌려줌 -----
//	@PostMapping("/calculate")
//	public CalculationResponse postMethodName(@RequestBody CalculationRequest request) {
// //		request ==>> num1=100, num2=50, operation="ADD"
//
// //		result(150) = 더하기(100,50)
//		double result = calculatorService.add(request.getNum1(), request.getNum2());
//
// //		출력포맷을 결정 결정
// //		num1=100, num2=50, operation="ADD", result=150
//		return new CalculationResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);
//	}
	
//	테스트: http://localhost:8090/calculator/calculate
//	{
//	    "num1": 100,
//	    "num2": 50,
//	    "operation": "*"
//	}
	@PostMapping("/calculate")
	public CalculationResponse postMethodName(@RequestBody CalculationRequest request) {
		
//		+ - * /
		double result = calculatorService.calculate(request.getNum1(), request.getNum2(), request.getOperation());
		
		return new CalculationResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);
	}

}
