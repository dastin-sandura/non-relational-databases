// use('nbd')
var mapFunction = function(){
    emit(this.job,null);
//   emit(this.nationality, {
    //   count : 0,
    //   height: Number(this.height),
    //   weight: Number(this.weight)
    // })
};
var reduceFunction = function(job, jobVal){
  return job;
};
var finalizeFunction = function(nationality, reducedValues) {
    reducedValues.avgWeight = reducedValues.weight/reducedValues.count;
    reducedValues.avgHeight = reducedValues.height/reducedValues.count;
    return reducedValues;
}
db.people.mapReduce(
  mapFunction,
  reduceFunction,
  {
    out: "map_reduce_3"
  }
)

printjson(db.map_reduce_3.find().sort( { _id: 1 } ).toArray())