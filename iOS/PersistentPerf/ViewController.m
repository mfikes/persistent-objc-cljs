//
//  ViewController.m
//  PersistentPerf
//
//  Created by Mike Fikes on 11/12/14.
//
//

#import "ViewController.h"

#import "GBYLabel.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)handleViewDidLoad {
    
    [[self getFunction:@"view-did-load!"]
     callWithArguments:@[self,
                         [GBYLabel wrap:self.objCTimeLabel],
                         [GBYLabel wrap:self.cljsTimeLabel]]];
}

- (NSString*)getNamespace
{
    return @"persistent-perf.view-controller";
}

@end
