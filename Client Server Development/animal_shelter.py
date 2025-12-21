# Python Testing Script


from pymongo import MongoClient
from bson.objectid import ObjectId


class AnimalShelter(object):
    def __init__(self,username,password,port=27017):
        self.client = MongoClient(f'mongodb://{username}:{password}@localhost:{port}')
        self.database = self.client["AAC"]
        self.collection = self.database["animals"]
        

    def create(self,data):
        if data is not None:
            #parameters should consist of a dictionary
            insert = self.collection.insert_one(data)
            if insert!=0:
                return True
            else:
                return False
        else:
            raise Exception("Nothing to save, data parameter empty")


    def read(self,criteria=None):
        if criteria is not None:
            data = self.collection.find(criteria,{"_id":False})
            """for document in data:
                print(document)"""
        else:
            data = self.collection.find({},{"_id":False})
            
        return data
    
    def update(self,data,updateData):
        if data is not None:
            if self.database.animals.count_documents(data,limit = 1) !=0:
                update_result = self.database.animals.update_many(data,{"$set":updateData})
                result = update_result.raw_result
            else:
                result = "Document not found"
            return result
        else:
            raise Exception("parameter empty, nothing to update")
    
    def delete(self,deleteData):
        if data is not None:
            if self.database.animals.count_documents(deleteData,limit = 1) !=0:
                delete_result = self.database.animals.update_many(deleteData)
                result = update_result.raw_result
            else:
                result = "Document not found"
            return result
        else:
            raise Exception("parameter empty, nothing to delete")