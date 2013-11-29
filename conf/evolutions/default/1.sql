# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table archive_it_collection (
  id                        bigint not null,
  name                      varchar(255),
  frequency                 integer,
  topic1                    integer,
  topic2                    integer,
  topic3                    integer,
  date_created              timestamp,
  date_last_crawl           timestamp,
  date_next_crawl           timestamp,
  status                    integer,
  constraint ck_archive_it_collection_frequency check (frequency in (0,1,2,3,4)),
  constraint ck_archive_it_collection_topic1 check (topic1 in (0,1,2,3,4,5,6,7,8,9,10)),
  constraint ck_archive_it_collection_topic2 check (topic2 in (0,1,2,3,4,5,6,7,8,9,10)),
  constraint ck_archive_it_collection_topic3 check (topic3 in (0,1,2,3,4,5,6,7,8,9,10)),
  constraint ck_archive_it_collection_status check (status in (0,1,2)),
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
  type                      integer,
  collection_id             bigint,
  constraint ck_seed_type check (type in (0,1,2)),
  constraint pk_seed primary key (id))
;

create sequence archive_it_collection_seq;

create sequence metadata_seq;

create sequence seed_seq;

alter table metadata add constraint fk_metadata_collection_1 foreign key (collection_id) references archive_it_collection (id) on delete restrict on update restrict;
create index ix_metadata_collection_1 on metadata (collection_id);
alter table seed add constraint fk_seed_collection_2 foreign key (collection_id) references archive_it_collection (id) on delete restrict on update restrict;
create index ix_seed_collection_2 on seed (collection_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists archive_it_collection;

drop table if exists metadata;

drop table if exists seed;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists archive_it_collection_seq;

drop sequence if exists metadata_seq;

drop sequence if exists seed_seq;

