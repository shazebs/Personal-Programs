using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Whiteboard
{
    class Thing
    {
        public int id { get; set; }
        public String name { get; set; }
        public float price { get; set; }
        public override string ToString()
        {
            return "This thing is called " + name +
                   " and it costs " + price +
                   ". It has an id number of " + id; 
        }
        // Constructor
        public Thing(int id, string name, float price)
        {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}
