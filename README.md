# excess-eats
An app that aims to reduce food waste in NYC by connecting restaurants with customers by offering discounts on excess food and meals.

## This was made for CUNY HACKATHON FALL 2017

This repo contains a Spring Boot app that exposes a REST API for "Eats" and "Producers" These are the two domain objects in the Excess Eats platform.
an "Eat" is an advertisement for discounted food at a physical location in NYC. "Producers" are restaurants, grocery stores, or any other food-selling establishment.

"Producers" add "Eats" to the system and these "Eats" are broadcast to the users of the platform so they can claim them in the physical location.

## API

GET /eats/all
	returns an array of all eats.

GET /eats/{id}
	returns a singular eat with the {id}:
	
	{
		id: 1,
		description: "Half off bread loaves",
		producer: "Cafe",
		producerId: 1,
		expired: false,
		expires: "2017-11-11T23:24:38.995+0000",
		price: 2,
		discount: 0.5,
		discountedPrice: 1
	}
	

GET /eats/producer/{id}
	returns an array of eats with producerId = {id}.

POST /eats/producer/{id}
	adds an eat to the DB that belongs to the producer
	with producerId of {id}:

	POST a JSON object with this structure: 

	{
    	"id": 10,
    	"description": "test",
    	"expires": "2017-11-11T23:24:38.995+0000",
    	"expired": false,
    	"price": 45,
    	"discount": 0.34
	}



GET /prods
	returns an array of all producers.

GET /prods/{id} returns a single producer along with an array of all of it's eats:
	
	{
		id: 1,
		name: "Cafe",
		address: "555 1st Avenue",
		phone: "212-555-3455",
		hours: "8am-8pm",
		eats: [
			{
				id: 1,
				description: "Half off bread loaves",
				producer: "Cafe",
				producerId: 1,
				expired: false,
				expires: "2017-11-11T23:24:38.995+0000",
				price: 2,
				discount: 0.5,
				discountedPrice: 1
			},
			{
				id: 2,
				description: "Burgers",
				producer: "Cafe",
				producerId: 1,
				expired: false,
				expires: "2017-11-11T23:24:39.055+0000",
				price: 2,
				discount: 0.7,
				discountedPrice: 0.6000000000000001
			},
			{
				id: 3,
				description: "Cupcakes 50% off",
				producer: "Cafe",
				producerId: 1,
				expired: false,
				expires: "2017-11-11T23:24:39.057+0000",
				price: 2,
				discount: 0.4,
				discountedPrice: 1.2
			}
		]
	}
