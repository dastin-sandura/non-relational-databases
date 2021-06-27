// use('nbd')
var mapFunction = function(){
    emit(this.job,null);

};
var reduceFunction = function(job, jobVal){
  return job;
};
db.people.mapReduce(
  mapFunction,
  reduceFunction,
  {
    out: "map_reduce_3"
  }
)

printjson(db.map_reduce_3.find().sort( { _id: 1 } ).toArray())