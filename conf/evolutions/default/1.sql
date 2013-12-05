# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table alert_message (
  id                        bigint not null,
  subscription_id           bigint,
  message                   varchar(255),
  link                      varchar(255),
  constraint pk_alert_message primary key (id))
;

create table archive_it_collection (
  id                        bigint not null,
  name                      varchar(255),
  frequency                 varchar(2),
  topic1                    varchar(12),
  topic2                    varchar(12),
  topic3                    varchar(12),
  date_created              timestamp,
  date_last_crawl           timestamp,
  date_next_crawl           timestamp,
  status                    varchar(1),
  privacy                   varchar(7),
  constraint ck_archive_it_collection_frequency check (frequency in ('Q','S','BM','W','M','2D','D','A')),
  constraint ck_archive_it_collection_topic1 check (topic1 in ('UNIVERSITIES','GOV','GOV_COUNTIES','ARTS','POLITICS','COMPUTERS','BLOGS','EVENTS','SCIENCE','GOV_CITIES','SOCIETY')),
  constraint ck_archive_it_collection_topic2 check (topic2 in ('UNIVERSITIES','GOV','GOV_COUNTIES','ARTS','POLITICS','COMPUTERS','BLOGS','EVENTS','SCIENCE','GOV_CITIES','SOCIETY')),
  constraint ck_archive_it_collection_topic3 check (topic3 in ('UNIVERSITIES','GOV','GOV_COUNTIES','ARTS','POLITICS','COMPUTERS','BLOGS','EVENTS','SCIENCE','GOV_CITIES','SOCIETY')),
  constraint ck_archive_it_collection_status check (status in ('D','I','A')),
  constraint ck_archive_it_collection_privacy check (privacy in ('PRIVATE','PUBLIC')),
  constraint pk_archive_it_collection primary key (id))
;

create table metadata (
  id                        bigint not null,
  key                       varchar(255),
  value                     varchar(255),
  collection_id             bigint,
  constraint pk_metadata primary key (id))
;

create table seed (
  id                        bigint not null,
  url                       varchar(255),
  type                      varchar(8),
  frequency                 varchar(2),
  date_created              timestamp,
  date_last_crawled         timestamp,
  status                    varchar(1),
  verified                  boolean,
  login_username            varchar(255),
  login_password            varchar(255),
  collection_id             bigint,
  constraint ck_seed_type check (type in ('NEWS_RSS','ONE_PAGE','DEFAULT')),
  constraint ck_seed_frequency check (frequency in ('Q','S','BM','W','M','2D','D','A')),
  constraint ck_seed_status check (status in ('D','I','A')),
  constraint pk_seed primary key (id))
;

create table seed_comment (
  id                        bigint not null,
  text                      varchar(255),
  date_created              timestamp,
  show                      boolean,
  user_id                   bigint,
  seed_id                   bigint,
  constraint pk_seed_comment primary key (id))
;

create sequence alert_message_seq;

create sequence archive_it_collection_seq;

create sequence metadata_seq;

create sequence seed_seq;

create sequence seed_comment_seq;

alter table metadata add constraint fk_metadata_collection_1 foreign key (collection_id) references archive_it_collection (id) on delete restrict on update restrict;
create index ix_metadata_collection_1 on metadata (collection_id);
alter table seed add constraint fk_seed_collection_2 foreign key (collection_id) references archive_it_collection (id) on delete restrict on update restrict;
create index ix_seed_collection_2 on seed (collection_id);
alter table seed_comment add constraint fk_seed_comment_seed_3 foreign key (seed_id) references seed (id) on delete restrict on update restrict;
create index ix_seed_comment_seed_3 on seed_comment (seed_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists alert_message;

drop table if exists archive_it_collection;

drop table if exists metadata;

drop table if exists seed;

drop table if exists seed_comment;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists alert_message_seq;

drop sequence if exists archive_it_collection_seq;

drop sequence if exists metadata_seq;

drop sequence if exists seed_seq;

drop sequence if exists seed_comment_seq;

