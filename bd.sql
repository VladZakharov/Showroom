create TABLE CarBrand (
    id bigint IDENTITY(1,1) not null,
    name varchar(255) UNIQUE not null,
    PRIMARY KEY (id)
);

create TABLE CarCondition (
    id bigint IDENTITY(1,1) not null,
    name varchar(255) UNIQUE not null,
    PRIMARY KEY (id)
);

create TABLE cars (
    id bigint IDENTITY(1,1) not null,
    extras varchar(255),
    grad_year int,
    price int not null,
    brand_id bigint not null,
    condition_id bigint not null,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES CarBrand (id),
    FOREIGN KEY (condition_id) REFERENCES CarCondition (id)
);

create TABLE Color (
    id bigint IDENTITY(1,1) not null,
    name varchar(255) UNIQUE not null,
    PRIMARY KEY (id)
);

create TABLE CarSpecifications (
    id bigint IDENTITY(1,1) not null,
    acceleration float not null,
    engineVolume int not null,
    horsePowers int not null,
    topSpeed int not null,
    car_id bigint,
    color_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (car_id) REFERENCES cars (id),
    FOREIGN KEY (color_id) REFERENCES Color (id)
);

create TABLE CustomerDemands (
    id bigint IDENTITY(1,1) not null,
    maxEngineVolume int not null,
    maxHorsePower int not null,
    maxPrice int not null,
    maxTopSpeed int not null,
    minEngineVolume int not null,
    minHorsePower int not null,
    minPrice int not null,
    minTopSpeed int not null,
    PRIMARY KEY (id)
);

create TABLE CustomerDemands_CarBrand (
    CustomerDemands_id bigint not null,
    brands_id bigint not null,
    FOREIGN KEY (CustomerDemands_id) REFERENCES CustomerDemands (id) ON DELETE CASCADE,
    FOREIGN KEY (brands_id) REFERENCES CarBrand (id)
);

create TABLE CustomerDemands_CarCondition (
    CustomerDemands_id bigint not null,
    conditions_id bigint not null,
    FOREIGN KEY (CustomerDemands_id) REFERENCES CustomerDemands (id) ON DELETE CASCADE,
    FOREIGN KEY (conditions_id) REFERENCES CarCondition (id)
);

create TABLE CustomerDemands_Color (
    CustomerDemands_id bigint not null,
    colors_id bigint not null,
    FOREIGN KEY (CustomerDemands_id) REFERENCES CustomerDemands (id) ON DELETE CASCADE,
    FOREIGN KEY (colors_id) REFERENCES Color (id)
);

create TABLE CustomerInfo (
    id bigint IDENTITY(1,1) not null,
    mobile varchar(255) not null,
    PRIMARY KEY (id)
);

create TABLE customers (
    id bigint IDENTITY(1,1) not null,
    firstName varchar(255) not null,
    lastName varchar(255),
    middleName varchar(255),
    info_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (info_id) REFERENCES CustomerInfo (id)
);

create TABLE customers_CustomerDemands (
    customers_id bigint not null,
    demands_id bigint not null,
    FOREIGN KEY (customers_id) REFERENCES customers (id) ON DELETE CASCADE,
    FOREIGN KEY (demands_id) REFERENCES CustomerDemands (id) ON DELETE CASCADE
);

create table CarOrder (
	id bigint IDENTITY(1,1) not null,
	car_id bigint not null,
	cust_id bigint not null,
	FOREIGN key (car_id) references cars,
	FOREIGN key (cust_id) references customers
);