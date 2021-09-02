<<<<<<< HEAD
## Week3
#### 스프링부트 환경 세팅
#### SW활용 현황 통계 API 구축
</br>



##### 1. 연도별 로그인 수 조회
  <img src = "https://user-images.githubusercontent.com/65826145/130973688-8a3ab25e-51c5-48cd-8ef8-4725d8bd569e.png" width = "350">

##### 2. 월별 로그인 수 조회
  <img src = "https://user-images.githubusercontent.com/65826145/130973783-b5a98e4b-00ba-428e-8f39-da03ac59654a.png" width = "350">

##### 3. 일별 하루 로그인 수
  <img src = "https://user-images.githubusercontent.com/65826145/130973931-df2bec2e-532a-4b19-a59f-3e871d0c08be.png" width = "350">

##### 4. 평균 하루 로그인 수
  <img src = "https://user-images.githubusercontent.com/65826145/130974108-9d20600d-1a9e-4c56-8932-d547487a8d51.png" width = "350">

##### 5. 휴일을 제외한 로그인 수
  <img src = "https://user-images.githubusercontent.com/65826145/130974238-8ba5a4c8-3975-427b-8a90-31d759b2aec5.png" width = "350">

##### 6. 부서별 월별 로그인 수
  <img src = "https://user-images.githubusercontent.com/65826145/130974333-a37080cd-7337-4e18-ba15-fd1831923d6d.png" width = "350">

##### +) Database
 <img src="https://user-images.githubusercontent.com/65826145/130974444-5db533b9-9dbd-47cd-97fc-6db67fd65c03.png" width="200">
 <img src= "https://user-images.githubusercontent.com/65826145/130977674-59995b03-1687-4c0d-8382-c114514b13a2.png" width="200">

=======
### Week3
+ 스프링부트 환경 세팅
+ SW활용 현황 통계 API 구축

_______________________________


#### 1. 실행 화면
![image](https://user-images.githubusercontent.com/65826145/131802585-cd653967-8559-4fc2-a100-4f656a6fe23c.png)

#### +) Database
 <img src="https://user-images.githubusercontent.com/65826145/131799128-31decced-4e04-4b3d-afdc-9c1a9d5ce969.png" width="700">
 
 _______________________________
 
 
 #### 2. SQL

1. 연도별 로그인 수 조회
```sql
<select id="selectYearLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistc.requestinfo ri
        where left(ri.createDate, 2) = #{year};
</select>
```

2. 월별 로그인 수 조회
```sql
<select id="selectMonthLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistc.requestinfo ri
        where mid(ri.createDate, 3, 2) = #{month};
</select>
```

3. 일별 하루 로그인 수 조회
```sql
<select id="selectDayLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistc.requestinfo ri
        where left(ri.createDate, 2) = #{year}
        and mid(ri.createDate, 3, 2) = #{month}
        and mid(ri.createDate, 5, 2) = #{day};
</select>
```

4. 평균 하루 로그인 수 조회
```sql
 <select id="selectAverageLogin" parameterType="string" resultType="hashMap">
        select avg(totCnt)
        from(
          select count(*) as totCnt
          from statistc.requestinfo
          group by createDate
        ) as totAvg;
</select>
```

5. 휴일을 제외한 로그인 수 조회
```sql
 <select id="selectnotHolidayLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from  statistc.requestinfo ri
        where not exists (
        select *
        from statistc.holiday
        where mid(ri.createDate, 3, 4) = holiday.holidayDate
        );
</select>
```

6. 부서별 월별 로그인 수 조회
```sql
<select id="selectorganMonthLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from  statistc.requestinfo ri, statistc.user
        where ri.userID = user.userID
        and HR_ORGAN = #{organ}
        and mid(ri.createDate,3,2) = #{month};
</select>
```
>>>>>>> bb3d0dc36a78999381bdadf6dd503bf744d87f14
