USE HOTELAPP;


# PRIMARY KEY CONSTRAINT

ALTER TABLE admin
ADD CONSTRAINT admin_pk
PRIMARY KEY(adminid); 

ALTER TABLE bill
ADD CONSTRAINT bill_pk
PRIMARY KEY(invoiceno); 

ALTER TABLE booking
ADD CONSTRAINT booking_pk
PRIMARY KEY(bookingid);

ALTER TABLE client
ADD CONSTRAINT client_pk
PRIMARY KEY(clientid);

ALTER TABLE room
ADD CONSTRAINT room_pk
PRIMARY KEY(roomno);

# FOREIGN KEY CONSTRAINT

# BILL

ALTER TABLE bill
ADD CONSTRAINT bill_booking_fk
FOREIGN KEY(bookingid)
REFERENCES booking(bookingid);

ALTER TABLE bill
ADD CONSTRAINT bill_client_fk
FOREIGN KEY(clientid)
REFERENCES client(clientid);

# BOOKING 

ALTER TABLE booking
ADD CONSTRAINT booking_client_fk
FOREIGN KEY(clientid)
REFERENCES client(clientid);

ALTER TABLE booking
ADD CONSTRAINT booking_room_fk
FOREIGN KEY(roomno)
REFERENCES room(roomno);

ALTER TABLE booking
ADD CONSTRAINT booking_bill_fk
FOREIGN KEY(invoiceno)
REFERENCES bill(invoiceno);


# CLIENT

ALTER TABLE client
ADD CONSTRAINT client_booking_fk
FOREIGN KEY(bookingid)
REFERENCES booking(bookingid);

# UNIQUE CONSTRAINT

# CLIENT

ALTER TABLE client
ADD CONSTRAINT client_email_uk
UNIQUE(email);

ALTER TABLE client
ADD CONSTRAINT client_phoneno_uk
UNIQUE(phoneno);

ALTER TABLE client
ADD CONSTRAINT client_title_id_uk
UNIQUE(clienttitleno);

# BILL 

ALTER TABLE bill
ADD CONSTRAINT bill_credit_no_uk
UNIQUE(creditcardno);

# ADMIN

ALTER TABLE admin
ADD CONSTRAINT admin_email_uk
UNIQUE(email);

ALTER TABLE admin
ADD CONSTRAINT admin_phoneno_uk
UNIQUE(phoneno);

ALTER TABLE admin
ADD CONSTRAINT admin_title_id_uk
UNIQUE(admintitleno);
