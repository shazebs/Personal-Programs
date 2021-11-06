using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Whiteboard
{
    class Vacation
    {
        public string vacationName { get; set; }
        public string location { get; set; }
        public DateTime startingDate { get; set; }
        public int daysOfTrip { get; set; }
        public string description { get; set; }
        public float price { get; set; }
        public string photoURL { get; set; }
        public override string ToString()
        {
            return vacationName + " package tour to " + location + " starting " +
                    startingDate.Month + "/" + startingDate.Day + "/" + startingDate.Year + " for " + daysOfTrip + " days\n\tDescription: " +
                    description + " priced at $" + price + " - " +
                    photoURL + "\n"; 
        }
        // Constructor. 
        public Vacation(string vacationName, string location, DateTime startingDate, int daysOfTrip, string description, float price, string photoURL)
        {
            this.vacationName = vacationName;
            this.location = location;
            this.startingDate = startingDate;
            this.daysOfTrip = daysOfTrip;
            this.description = description;
            this.price = price;
            this.photoURL = photoURL; 
        }
    }
}
