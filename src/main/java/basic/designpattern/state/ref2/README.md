## 
## enum을 적용하려 할때 에러가 났던 사항
### 참고하고자 했던 예제
- 우아한형제들 기술블로그 
http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
- java enum의 10가지 예제
https://bluepoet.me/2012/07/18/%EB%B2%88%EC%97%AD%EC%9E%90%EB%B0%94-enum%EC%9D%98-10%EA%B0%80%EC%A7%80-%EC%98%88%EC%A0%9C/


1. enum 안에 int형 자료를 넣고 싶을때 에러 발생
https://stackoverflow.com/questions/8835689/java-enum-giving-an-error
알고보니 enum클래스 내에서 처리를 해줄 생성자에 정의할 모든 타입들을 열거하고, getter를 정의해주면 되는 거였다.

2. 여러 타입의 자료를 넣고자 할때는 각각의 자료형에 맞는 생성자를 만들어주고, getter를 생성해주면 된다.

3. 우아한 형제들 기술 블로그에서는 lombok의 @Getter를 사용하는 걸 추천했다.

