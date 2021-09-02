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

