// use('nbd')
var mapFunction = function(){
    this.credit.forEach(e => {
        emit(e.currency,{ 
            count: 1,
            balance: Number(e.balance)
        })
    });
};
var reduceFunction = function(currency, bal){
    var coun = 0
    var sumBa = 0
    bal.forEach(b => {
        sumBa+=b.balance
        coun+=b.count
    })
    return {count:coun, balance:sumBa};
};
var finalizeFunction = function(currency, vals) {
    var result = {
        sum: vals.balance,
        average: vals.balance/vals.count
    }; 
    //count the average
    return result;
}
db.people.mapReduce(
  mapFunction,
  reduceFunction,
  {
    out: "map_reduce_5",
    finalize: finalizeFunction,
    query: {"$and" : 
        [
            {sex: {"$eq":"Female"}},
            {nationality: {"$eq": "Poland"}}
        ]
    }
  }
)

printjson(db.map_reduce_5.find().sort( { _id: 1 } ).toArray())