insert into company(name, nation, location)
values ('논술메이트', '한국', '역삼');
insert into company(name, nation, location)
values ('건빵', '한국', '가좌');

insert into recruit(company_id, content, tech_stack, position, recruitment_bonus)
values (1, '함께 성장할 개발자를 기다립니다', 'Spring Boot', 'Back-end', 1000000);
insert into recruit(company_id, content, tech_stack, position, recruitment_bonus)
values (1, '함께 성장할 개발자를 기다립니다', 'Spring', 'Back-end', 2000000);

insert into recruit(company_id, content, tech_stack, position, recruitment_bonus)
values (2, 'iOS 네이티브 개발자를 기다립니다', 'Xcode', 'iOS', 1000000);