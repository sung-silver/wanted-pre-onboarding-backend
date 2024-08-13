# wanted-pre-onboarding-backend

## 서비스 개요
- 본 서비스는 기업의 채용을 위한 웹 서비스 입니다.
- 회사는 채용공고를 생성하고, 이에 사용자는 지원합니다.


## 필수 기술요건
- ORM 사용하여 구현.
- RDBMS 사용 (SQLite, PostgreSQL,MySql 등).


## 요구사항 및 구현 PR
1. 채용공고를 등록합니다. [채용 공고 등록 API 구현](https://github.com/sung-silver/wanted-pre-onboarding-backend/pull/6)
2. 채용공고를 수정합니다. [채용 공고 수정 API 구현](https://github.com/sung-silver/wanted-pre-onboarding-backend/pull/8)
3. 채용공고를 삭제합니다. [채용 공고 삭제 API 구현](https://github.com/sung-silver/wanted-pre-onboarding-backend/pull/10)
4. 채용공고 목록을 가져옵니다. [채용 공고 목록 조회(일반, 검색) API 구현](https://github.com/sung-silver/wanted-pre-onboarding-backend/pull/12)
5. 채용 상세 페이지를 가져옵니다. [채용 공고 상세정보 조회 API 구현](https://github.com/sung-silver/wanted-pre-onboarding-backend/pull/14)
6. 사용자는 채용공고에 지원합니다. [채용 공고 지원 API 구현](https://github.com/sung-silver/wanted-pre-onboarding-backend/pull/16)


## Project Information
- Java 17
- Spring Boot 3.3.2
- Spring Boot Data JPA
- H2
- Git
- `src/main/resources/application-secret.properties`
  <details>
  <summary>파일 내용</summary>

  ```properties
  ### LOCAL
  LOCAL_DATABASE_URL=jdbc:h2:mem:wanted-local-db;DATABASE_TO_UPPER=FALSE;mode=mysql
  LOCAL_DATABASE_USERNAME=sa

  ### TEST
  TEST_DATABASE_URL=jdbc:h2:mem:wanted-test-db;DATABASE_TO_UPPER=FALSE;mode=mysql
  TEST_DATABASE_USERNAME=sa


## Project Structure
``` JSX
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃   ┗ 📂example
 ┃ ┃     ┗ 📂wanted
 ┃ ┃       ┣ 📂common
 ┃ ┃       ┃ ┣ 📂exception
 ┃ ┃       ┃ ┃ ┣ 📂exceptionType
 ┃ ┃       ┃ ┃ ┃ ┣ 📜ApplyExceptionType.java
 ┃ ┃       ┃ ┃ ┃ ┣ 📜CommonExceptionType.java
 ┃ ┃       ┃ ┃ ┃ ┣ 📜CompanyExceptionType.java
 ┃ ┃       ┃ ┃ ┃ ┣ 📜ExceptionType.java
 ┃ ┃       ┃ ┃ ┃ ┣ 📜MemberExceptionType.java
 ┃ ┃       ┃ ┃ ┃ ┗ 📜RecruitExceptionType.java
 ┃ ┃       ┃ ┃ ┣ 📜ClientException.java
 ┃ ┃       ┃ ┃ ┗ 📜CustomExceptionHandler.java
 ┃ ┃       ┃ ┗ 📂vo
 ┃ ┃       ┃   ┣ 📜ApplyIdVO.java
 ┃ ┃       ┃   ┣ 📜RecruitDetailVO.java
 ┃ ┃       ┃   ┣ 📜RecruitIdVO.java
 ┃ ┃       ┃   ┗ 📜RecruitVO.java
 ┃ ┃       ┣ 📂controller
 ┃ ┃       ┃ ┣ 📂dto
 ┃ ┃       ┃ ┃ ┣ 📂request
 ┃ ┃       ┃ ┃ ┃ ┣ 📜CreateApplyRequestDTO.java
 ┃ ┃       ┃ ┃ ┃ ┣ 📜CreateRecruitRequestDTO.java
 ┃ ┃       ┃ ┃ ┃ ┗ 📜UpdateRecruitRequestDTO.java
 ┃ ┃       ┃ ┃ ┗ 📂response
 ┃ ┃       ┃ ┃   ┣ 📜RecruitDetailResponseDTO.java
 ┃ ┃       ┃ ┃   ┗ 📜RecruitResponseDTO.java
 ┃ ┃       ┃ ┣ 📜ApplyController.java
 ┃ ┃       ┃ ┗ 📜RecruitController.java
 ┃ ┃       ┣ 📂domain
 ┃ ┃       ┃ ┣ 📜Apply.java
 ┃ ┃       ┃ ┣ 📜Company.java
 ┃ ┃       ┃ ┣ 📜Member.java
 ┃ ┃       ┃ ┗ 📜Recruit.java
 ┃ ┃       ┣ 📂repository
 ┃ ┃       ┃ ┣ 📜ApplyRepository.java
 ┃ ┃       ┃ ┣ 📜CompanyRepository.java
 ┃ ┃       ┃ ┣ 📜MemberRepository.java
 ┃ ┃       ┃ ┗ 📜RecruitRepository.java
 ┃ ┃       ┣ 📂service
 ┃ ┃       ┃ ┣ 📜ApplyService.java
 ┃ ┃       ┃ ┗ 📜RecruitService.java
 ┃ ┃       ┗ 📜WantedApplication.java
 ┃ ┗ 📂resources
 ┃   ┣ 📜application-local.yml
 ┃   ┣ 📜application-secret.properties
 ┃   ┣ 📜application-test.yml
 ┃   ┗ 📜data.sql
 ┗ 📂test
   ┗ 📂java
     ┗ 📂com
       ┗ 📂example
         ┗ 📂wanted
           ┣ 📂Fixture
           ┃ ┣ 📜CompanyFixture.java
           ┃ ┣ 📜MemberFixture.java
           ┃ ┗ 📜RecruitFixture.java
           ┣ 📂domain
           ┃ ┣ 📜ApplyTest.java
           ┃ ┣ 📜CompanyTest.java
           ┃ ┣ 📜MemberTest.java
           ┃ ┗ 📜RecruitTest.java
           ┣ 📂repository
           ┃ ┣ 📜ApplyRepositoryTest.java
           ┃ ┣ 📜CompanyRepositoryTest.java
           ┃ ┣ 📜MemberRepositoryTest.java
           ┃ ┗ 📜RecruitRepositoryTest.java
           ┗ 📜WantedApplicationTests.java
```


## ERD
<img src="https://github.com/user-attachments/assets/0e84be13-cca2-4689-b64c-81d5dafb2df3" alt="wanted" width="550">


## Git convention
### Branch
- 할 일 issue 등록 후, `issue number`를 사용하여 branch 생성 후 작업
    - ex) feat/#issue_number
- branch naming
    - 기능 개발 - `feat`
    - 리팩토링 - `refactor`
    - 수정 - `fix`
    - 테스트 - `test`
- branch 구조
    
```bash
main
  ├── feat/#1
  └── feat/#2
```

### Commit
```jsx
- [CHORE]: 내부 파일 수정
- [FEAT] : 새로운 기능 구현
- [ADD] : FEAT 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성 시
- [FIX] : 코드 수정, 버그, 오류 해결
- [DEL] : 쓸모없는 코드 삭제
- [DOCS] : README나 WIKI 등의 문서 개정
- [MOVE] : 프로젝트 내 파일이나 코드의 이동
- [RENAME] : 파일 이름의 변경
- [MERGE]: 다른 브렌치를 merge하는 경우
- [STYLE] : 코드가 아닌 스타일 변경을 하는 경우
- [INIT] : Initial commit을 하는 경우
- [REFACTOR] : 로직은 변경 없는 클린 코드를 위한 코드 수정
```

