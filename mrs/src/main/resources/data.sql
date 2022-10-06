--会議室
INSERT INTO public.meeting_room(room_name) VALUES ('新木場');
INSERT INTO public.meeting_room(room_name) VALUES ('辰巳');
INSERT INTO public.meeting_room(room_name) VALUES ('豊洲');
INSERT INTO public.meeting_room(room_name) VALUES ('月島');
INSERT INTO public.meeting_room(room_name) VALUES ('新富町');
INSERT INTO public.meeting_room(room_name) VALUES ('銀座一丁目');
INSERT INTO public.meeting_room(room_name) VALUES ('有楽町');

--予約可能会議室
INSERT INTO public.reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 1);
INSERT INTO public.reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE-1, 1);
INSERT INTO public.reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE+1, 1);
INSERT INTO public.reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 7);
INSERT INTO public.reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE-1, 7);
INSERT INTO public.reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE+1, 7);

--ユーザ（パスワードはdemo）
INSERT INTO public.usr (user_id, first_name, last_name, password, role_name) VALUES ('aaaa', 'Aaa', 'Aaa', '2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea', 'USER');
INSERT INTO public.usr (user_id, first_name, last_name, password, role_name) VALUES ('bbbb', 'Bbb', 'Bbb', '2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea', 'USER');
INSERT INTO public.usr (user_id, first_name, last_name, password, role_name) VALUES ('cccc', 'Ccc', 'Ccc', '2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea', 'ADMIN');
INSERT INTO public.usr (user_id, first_name, last_name, password, role_name) VALUES ('taro-yamada', '山田', '太郎', '2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea', 'USER');
